package com.alvesjefs.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alvesjefs.hrpayroll.domain.Payment;
import com.alvesjefs.hrpayroll.domain.Worker;

@Service
public class PaymentService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${hr-worker.host}")
	private String workerHost;

	public Payment instantiatePayment(Long workerId, Integer days) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", ""+workerId);

		Worker worker = restTemplate.getForObject(workerHost + "/api/workers/{id}", Worker.class, uriVariables);

		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
