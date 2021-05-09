package org.amalitech.traineesdatarest.api;

import java.util.List;

import org.amalitech.traineesdatarest.entity.Trainee;
import org.amalitech.traineesdatarest.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TraineeController {
	
	@Autowired
	private TraineeService traineeService;
	
	@GetMapping("/trainees")
	public List<Trainee> getTrainees(){
		return traineeService.getTrainees();
	}
	
	
	@GetMapping("/trainee")
	public List<Trainee> getTraineesWithPageRequest(@RequestParam Integer pageNo, @RequestParam Integer pageSize, @RequestParam String sortBy){
		return traineeService.getTraineesWithPageRequest(pageNo, pageSize, sortBy);
	}
	
	
	@PostMapping("/trainee")
	public Trainee createTrainee(@RequestBody Trainee trainee) {
		return traineeService.createTrainee(trainee);
	}
	
	@PutMapping("/trainee/{id}")
	public Trainee updateTrainee(@PathVariable(name="id") Integer id ,@RequestBody Trainee trainee) {
		return traineeService.updateTrainee(id, trainee);
	}
	
	@DeleteMapping("/trainee/{id}")
	public void deleteTrainee(@PathVariable(name="id") Integer id) {
		traineeService.deleteTrainee(id);
	}
	

}
