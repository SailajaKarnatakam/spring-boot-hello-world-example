package com.sailaja.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.sailaja.entity.Customer;
import com.sailaja.entity.Transaction;

@RestController
public class RewardsController {

	private static final Customer Customer = null;
	
	@Autowired
	private RewardsService rewardsService;
	
	
	@GetMapping("/customers")
	public List<Customer> findCustomerAll() {
		return rewardsService.getCustomerAll();
	}
	
	@GetMapping("/customers/{customerId}")
    public ResponseEntity<?> getCustomerById(@PathVariable Integer customerId) {
        Optional<Customer> optionalCustomer = rewardsService.getCustomerById(customerId);

    if (optionalCustomer.isEmpty()) {
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found with ID: " + customerId);
    }

    return ResponseEntity.ok(optionalCustomer.get());
	
}}
