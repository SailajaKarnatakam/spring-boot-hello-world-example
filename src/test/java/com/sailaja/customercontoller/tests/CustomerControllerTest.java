package com.sailaja.customercontoller.tests;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.sailaja.entity.Customer;
import com.sailaja.service.RewardsController;
import com.sailaja.service.RewardsService;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(RewardsController.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;   

    @MockBean
    private RewardsService rewardsService;

    @InjectMocks
    private RewardsController rewardsController;

    @Test
    public void testGetCustomerById_CustomerFound() throws Exception {
        // Mocking the customer data
        Customer mockCustomer = new Customer(1, "John Doe");
        Optional<Customer> optionalCustomer = Optional.of(mockCustomer);

        // Mocking the service method behavior
        when(rewardsService.getCustomerById(1)).thenReturn(optionalCustomer);

        // Perform the GET request
        mockMvc.perform(get("/api/customers/1").contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.id").value(1))
               .andExpect(jsonPath("$.name").value("John Doe"));
              
    }

    @Test
    public void testGetCustomerById_CustomerNotFound() throws Exception {
        // Mocking the service method behavior when customer is not found
        when(rewardsService.getCustomerById(1)).thenReturn(Optional.empty());

        // Perform the GET request
        mockMvc.perform(get("/api/customers/1").contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isNotFound())
               .andExpect(content().string("Customer not found with ID: 1"));
    }

    // Add other test cases for the getAllCustomers and other controller methods if needed
}
