package org.amalitech.traineesdatarest.service;

import java.util.List;

import org.amalitech.traineesdatarest.entity.Trainee;
import org.amalitech.traineesdatarest.repository.TraineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class TraineeService {
	
	@Autowired
	private TraineeRepository traineeRepository;
	
	public List<Trainee> getTrainees(){
		return traineeRepository.findAll();
	}
	
	public List<Trainee> getTraineesWithPageRequest(Integer pageNo, Integer pageSize, String sortBy){
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		
		Page<Trainee> pagedResult = traineeRepository.findAll(paging);
		
		return pagedResult.getContent();
	}
	
	public Trainee createTrainee(Trainee trainee) {
		return traineeRepository.save(trainee);
	}
	
	public Trainee updateTrainee(Integer id, Trainee trainee) {
		Trainee traineeFound = traineeRepository.findById(id).orElseThrow();
		traineeFound.setFirstName(trainee.getFirstName());
		traineeFound.setLastName(trainee.getLastName());
		traineeFound.setEmail(trainee.getEmail());
		traineeRepository.save(traineeFound);
		return traineeFound;
	}
	
	public void deleteTrainee(Integer id) {
		traineeRepository.deleteById(id);
	}
}
