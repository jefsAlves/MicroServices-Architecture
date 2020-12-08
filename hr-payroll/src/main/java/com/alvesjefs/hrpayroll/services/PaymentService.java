package com.alvesjefs.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alvesjefs.hrpayroll.WorkerFeingClients;
import com.alvesjefs.hrpayroll.domain.Payment;
import com.alvesjefs.hrpayroll.domain.Worker;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeingClients workerFeignClients;

	public Payment instantiatePayment(Long workerId, Integer days) {

		Worker worker = workerFeignClients.findById(workerId).getBody();

		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
