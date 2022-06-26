package ftn.corner.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ftn.corner.model.PestAttribute;
import ftn.corner.model.Plant;
import ftn.corner.model.User;
import ftn.corner.model.PlantTypes;
import ftn.corner.model.Symptoms;
import ftn.corner.service.TestService;

@RestController
public class TestController {


	private final TestService testService;
	
	
	@Autowired
	public TestController(TestService testService) {
		super();
		this.testService = testService;
	}



	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
	public String getQuestions(@RequestParam(required = false) int id) {

//		System.out.println(id);
//		
////		id = "milos";
//		User user = new User(id);
//		testService.insertUser(user);
		
//		return user.getName() + " - " + user.getLastname();
		
		Plant plant = new Plant();
		plant.setPlantType(PlantTypes.CORN);
		plant.setDaysOld(id);
		
		plant = (Plant) testService.fireRules(plant);
		
		System.out.println(plant.getGrowStage().toString());

		return plant.toString();
		
		
	}
	
	@RequestMapping(value = "/plant", method = RequestMethod.GET, produces = "application/json")
	public String getQuestions(@RequestParam(required = false) int old, @RequestParam(required = false) Set<Symptoms> symptoms, @RequestParam(required = false) Set<PestAttribute> pestAttributes) {


		Plant plant = new Plant();
		plant.setPlantType(PlantTypes.CORN);
		plant.setDaysOld(old);
		plant.setPestAttributes(pestAttributes);
		
//		ArrayList<Symptoms> symptoms = new ArrayList<Symptoms>();
//		symptoms.add(symptom);
//		
		plant.setSymptoms(symptoms);
		
		plant = (Plant) testService.fireRules(plant);
		
		System.out.println(plant.toString());

		return plant.toString();
		
		
	}
}
