package com.bap.bankaccount.service;

import java.util.List;

import com.bap.bankaccount.entity.Customer;

public interface CustomerService {

    Customer getCustomerById(Long id);
    Customer getCustomerByEmail(String email);
    List<Customer> getCustomers();
    Customer saveCustomer(Customer customer);
    Customer updateCustomer(Customer customer, Long id);
    void deleteCustomer(Long id);
    
} 
