package ftn.corner.service;

import ftn.corner.model.GrowStageTemplateModel;
import ftn.corner.model.GrowStages;
import ftn.corner.model.Plant;
import ftn.corner.model.PlantTypes;
import ftn.corner.model.dto.PlantInputDTO;
import ftn.corner.repository.PlantRepository;
import lombok.AllArgsConstructor;
import org.drools.template.ObjectDataCompiler;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PlantService extends CrudService<Plant> {

    private final PlantRepository plantRepository;
    private final KieContainer kieContainer;

    @Override
    protected JpaRepository<Plant, Long> getEntityRepository() {
        return plantRepository;
    }


    public Plant plantDrool(Long plantId, PlantInputDTO plantInputDTO) {
        Plant plant = this.findOne(plantId);

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
        kieSession1.insert(plant);
        kieSession1.fireAllRules();
        kieSession1.dispose();


        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(plant);
//        kieSession.insert(plantInputDTO.getPestAttributes());
//        kieSession.insert(plantInputDTO.getSymptoms());


        plantInputDTO.getPestAttributes().stream().forEach(x -> {
            kieSession.insert(x);
        });

        plantInputDTO.getSymptoms().stream().forEach(x -> {
            kieSession.insert(x);
        });
        kieSession.fireAllRules();
        kieSession.dispose();
        return plant;

    }
}
