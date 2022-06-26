package ftn.corner.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.drools.template.ObjectDataCompiler;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.corner.CornerApplication;
import ftn.corner.model.User;
import ftn.corner.model.*;


@Service
public class TestService {

	private final KieContainer kieContainer;

	@Autowired
	public TestService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}

	public User insertUser(User i) {
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(i);
		kieSession.fireAllRules();
		kieSession.dispose();
		return i;
	}
	
	public Object fireRules(Object i) {
		KieHelper kieHelper = new KieHelper();


		InputStream template = getClass().getResourceAsStream("/template_grow_stages.drt");
        
        List<GrowStageTemplateModel> data = new ArrayList<GrowStageTemplateModel>();
        
        data.add(new GrowStageTemplateModel(null, PlantTypes.CORN, 0, 10, GrowStages.GERMINATION));
        data.add(new GrowStageTemplateModel(null, PlantTypes.CORN, 10, 20, GrowStages.LEAF_DEVELOPMENT));
        data.add(new GrowStageTemplateModel(null, PlantTypes.CORN, 20, 30, GrowStages.TILLERING));
		data.add(new GrowStageTemplateModel(null, PlantTypes.CORN, 30, 40, GrowStages.SHOOT_DEVELOPMENT));
		data.add(new GrowStageTemplateModel(null, PlantTypes.CORN, 40, 50, GrowStages.BOLTING));

        ObjectDataCompiler converter = new ObjectDataCompiler();
        String drl = converter.compile(data, template);
        
        System.out.println(drl);

        kieHelper.addContent(drl, ResourceType.DRL);
        
//        Results results = kieHelper.verify();
		KieSession kieSession1 = kieHelper.build().newKieSession();
		kieSession1.insert(i);
		kieSession1.fireAllRules();
		kieSession1.dispose();

		ArrayList<PestAttribute> a1 = new ArrayList<PestAttribute>();
		a1.add(PestAttribute.WORM);
		a1.add(PestAttribute.INCH2);
//		Pest p1 = new Pest(null, Diagnoses.ELATERIDAE, a1);

		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(i);
//		kieSession.insert(p1);
		kieSession.fireAllRules();
		kieSession.dispose();
		return i;
	}
}
