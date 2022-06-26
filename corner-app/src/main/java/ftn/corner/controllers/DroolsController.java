package ftn.corner.controllers;

import ftn.corner.model.Plant;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DroolsController {

//    @PostMapping(value = "plants/")
//    public ResponseEntity<Plant> createPlant(@RequestBody Plant plant)  {
//
//        plant = plantService.save(plant);
//
//        return new ResponseEntity<>(plant, HttpStatus.OK);
//    }
}
