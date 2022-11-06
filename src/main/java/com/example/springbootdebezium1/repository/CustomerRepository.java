package com.example.springbootdebezium1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootdebezium1.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
