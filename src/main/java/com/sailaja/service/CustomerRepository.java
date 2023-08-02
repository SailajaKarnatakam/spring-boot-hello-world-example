package com.sailaja.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sailaja.entity.Customer;

@Repository
public interface CustomerRepository extends  JpaRepository<Customer, Integer> {

}
