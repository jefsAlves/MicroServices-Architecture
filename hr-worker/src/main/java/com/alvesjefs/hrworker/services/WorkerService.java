package com.alvesjefs.hrworker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alvesjefs.hrworker.domain.Worker;
import com.alvesjefs.hrworker.repository.WorkerRepository;
import com.alvesjefs.hrworker.services.exceptions.ObjectNotFoundException;

@Service
public class WorkerService {

	@Autowired
	private WorkerRepository workerRepository;

	public List<Worker> findAll(Worker workers) {
		return workerRepository.findAll();
	}

	public Worker findById(Long id) {
		Optional<Worker> worker = workerRepository.findById(id);
		return worker.orElseThrow(() -> new ObjectNotFoundException("Sorry, Object Not Found!"));
	}
}