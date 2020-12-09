package com.alvesjefs.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alvesjefs.hrpayroll.domain.Payment;
import com.alvesjefs.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value = "/api/payment")
public class PaymentResource {

	@Autowired
	private PaymentService paymentService;

	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping(value = "/{id}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long id, @PathVariable Integer days) {
		Payment payment = paymentService.instantiatePayment(id, days);
		return ResponseEntity.ok().body(payment);
	}

	public ResponseEntity<Payment> getPaymentAlternative(Long id, Integer days) {
		Payment payment = new Payment("Will Meet", 400.0, days);
		return ResponseEntity.ok().body(payment);
	}
}
