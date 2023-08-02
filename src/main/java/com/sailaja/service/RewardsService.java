package com.sailaja.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sailaja.entity.Customer;

@Service
public class RewardsService {
	

	@Autowired
	private CustomerRepository customerRepository;
	
	
	public List<Customer> getCustomerAll() {
		return customerRepository.findAll();
	}
	
	public Optional<Customer> getCustomerById(Integer Id) {
		Optional<Customer> customer = customerRepository.findById(Id);
		return customer;
}}
