package ftn.corner.controllers;

import ftn.corner.model.Plant;
import ftn.corner.model.dto.PlantInputDTO;
import ftn.corner.service.PlantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PlantController {

    private final PlantService plantService;

    @PostMapping(value = "plants")
    public ResponseEntity<Plant> createPlant(@RequestBody Plant plant)  {

        plant = plantService.save(plant);

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

        return new ResponseEntity<>(plant, HttpStatus.OK);
    }

    @PostMapping (value = "plants/{id}/calculate")
    public ResponseEntity<Plant> getPlants(@PathVariable Long id, @RequestBody PlantInputDTO plantInputDTO)  {

        Plant plant = plantService.plantDrool(id, plantInputDTO);

        return new ResponseEntity<>(plant, HttpStatus.OK);
    }
}
