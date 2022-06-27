package ftn.corner.controllers;

import ftn.corner.model.*;
import ftn.corner.model.dto.PlantInputDTO;
import ftn.corner.service.PlantService;
import ftn.corner.service.SoilMeasurementService;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class PlantController {

    private final PlantService plantService;
    private final SoilMeasurementService soilMeasurementService;

    @PostMapping(value = "plants")
    public ResponseEntity<Plant> createPlant(@RequestBody Plant plant)  {



        plant = plantService.save(plant);

        SoilMeasurement sm1 = new SoilMeasurement();
        sm1.setPlant(plant);
        sm1.setDatetime(LocalDateTime.now().minusDays(10));
        sm1.setPh(5.5f);


        SoilMeasurement sm2 = new SoilMeasurement();
        sm2.setPlant(plant);
        sm2.setDatetime(LocalDateTime.now().minusDays(10));
        sm2.setPh(5.6f);

        SoilMeasurement sm3 = new SoilMeasurement();
        sm3.setPlant(plant);
        sm3.setDatetime(LocalDateTime.now().minusDays(10));
        sm3.setPh(6f);

        soilMeasurementService.save(sm1);
        soilMeasurementService.save(sm2);
        soilMeasurementService.save(sm3);

        plant = plantService.findOne(plant.getId());


//        Treatment t = new Treatment();
//        t.setName("Pesticid E24");
//        t.setCode("E24");


        return new ResponseEntity<>(plant, HttpStatus.OK);
    }

    @GetMapping(value = "plants")
    public ResponseEntity<List<Plant>> getPlants()  {

        List<Plant> plants = plantService.findAll();

        return new ResponseEntity<>(plants, HttpStatus.OK);
    }


    @GetMapping(value = "plants/{id}")
    public ResponseEntity<Plant> getPlants(@PathVariable Long id)  {

        Plant plant = plantService.findOne(id);


        ArrayList<PestAttribute> pa = new ArrayList<PestAttribute>();
        pa.add(PestAttribute.ANTENA);
        pa.add(PestAttribute.INCH2);
        pa.add(PestAttribute.BUTTERFLY);
        new PestRule(Diagnoses.DRY_LEAFS, pa);

        return new ResponseEntity<>(plant, HttpStatus.OK);
    }

    @PostMapping (value = "plants/{id}/calculate")
    public ResponseEntity<Plant> getPlants(@PathVariable Long id, @RequestBody PlantInputDTO plantInputDTO)  {

        Plant plant = plantService.plantDrool(id, plantInputDTO);

        return new ResponseEntity<>(plant, HttpStatus.OK);
    }
}
