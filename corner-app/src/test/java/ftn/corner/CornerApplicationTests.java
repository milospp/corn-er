package ftn.corner;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.drools.template.ObjectDataCompiler;
import org.junit.jupiter.api.Test;
import org.kie.api.builder.Results;
import org.kie.api.runtime.KieSession;
import org.kie.dmn.core.util.KieHelper;
import org.springframework.boot.test.context.SpringBootTest;
import ftn.corner.model.*;

@SpringBootTest
class CornerApplicationTests {

	@Test
	void contextLoads() {
		InputStream template = CornerApplicationTests.class.getResourceAsStream("/template_grow_stages.drt");
        
        List<GrowStageTemplateModel> data = new ArrayList<GrowStageTemplateModel>();
        
        data.add(new GrowStageTemplateModel(null, PlantTypes.CORN, 0, 10, GrowStages.GERMINATION));
        data.add(new GrowStageTemplateModel(null, PlantTypes.CORN, 10, 20, GrowStages.LEAF_DEVELOPMENT));
        data.add(new GrowStageTemplateModel(null, PlantTypes.CORN, 20, 30, GrowStages.TILLERING));
        data.add(new GrowStageTemplateModel(null, PlantTypes.CORN, 30, 40, GrowStages.SHOOT_DEVELOPMENT));
        data.add(new GrowStageTemplateModel(null, PlantTypes.CORN, 40, 50, GrowStages.BOLTING));
        
        ObjectDataCompiler converter = new ObjectDataCompiler();
        String drl = converter.compile(data, template);
        
        System.out.println(drl);
        
	}

}
