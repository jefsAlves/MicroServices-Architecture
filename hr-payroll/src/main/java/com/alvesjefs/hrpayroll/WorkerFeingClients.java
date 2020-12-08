package com.alvesjefs.hrpayroll;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.alvesjefs.hrpayroll.domain.Worker;

@Component
@FeignClient(value = "hr-worker", url = "localhost:8001", path = "/api/workers")
public interface WorkerFeingClients {

	@GetMapping(value = "/{id}")
	ResponseEntity<Worker> findById(@PathVariable Long id);
}
