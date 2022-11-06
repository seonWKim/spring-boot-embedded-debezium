package com.example.springbootdebezium1.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.springbootdebezium1.entity.Customer;
import com.example.springbootdebezium1.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.debezium.data.Envelope.Operation;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void replicateData(Map<String, Object> customerData, Operation operation) {
        final ObjectMapper objectMapper = new ObjectMapper();
        final Customer customer = objectMapper.convertValue(customerData, Customer.class);

        if (Operation.DELETE == operation) {
            customerRepository.deleteById(customer.getId());
        } else {
            customerRepository.save(customer);
        }
    }
}
