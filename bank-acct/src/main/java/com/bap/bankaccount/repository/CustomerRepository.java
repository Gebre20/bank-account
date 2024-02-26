package com.bap.bankaccount.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.bap.bankaccount.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
    Optional<Customer> findByEmail(String email);
    
} 