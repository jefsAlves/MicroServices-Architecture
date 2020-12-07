package com.alvesjefs.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.alvesjefs.hrpayroll.domain.Payment;

@Service
public class PaymentService {

	public Payment instantiatePayment(Long workerId, Integer days) {
		return new Payment("Bob", 200.0, days);
	}
}
