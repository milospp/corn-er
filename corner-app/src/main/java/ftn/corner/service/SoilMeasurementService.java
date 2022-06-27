package ftn.corner.service;

import ftn.corner.model.*;
import ftn.corner.model.dto.PlantInputDTO;
import ftn.corner.repository.PlantRepository;
import ftn.corner.repository.SoilMeasurementRepository;
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
public class SoilMeasurementService extends CrudService<SoilMeasurement> {

    private final SoilMeasurementRepository soilMeasurementRepository;

    @Override
    protected JpaRepository<SoilMeasurement, Long> getEntityRepository() {
        return soilMeasurementRepository;
    }

}
