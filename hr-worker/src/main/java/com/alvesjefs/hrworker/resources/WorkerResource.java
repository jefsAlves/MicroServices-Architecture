package com.alvesjefs.hrworker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alvesjefs.hrworker.domain.Worker;
import com.alvesjefs.hrworker.services.WorkerService;

@RestController
@RequestMapping(value = "/api/workers")
public class WorkerResource {

	@Autowired
	private WorkerService workerService;

	@GetMapping
	public ResponseEntity<List<Worker>> findAll(Worker workers) {
		List<Worker> worker = workerService.findAll(workers);
		return ResponseEntity.ok().body(worker);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		Worker worker = workerService.findById(id);
		return ResponseEntity.ok().body(worker);
	}
}
