package com.bap.bankaccount.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bap.bankaccount.entity.Customer;
import com.bap.bankaccount.exception.EntityNotFoundException;
import com.bap.bankaccount.repository.CustomerRepository;


import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class CustomerServiceImplementation implements CustomerService{

    private CustomerRepository customerRepository;

    @Override
    public Customer getCustomerById(Long id) {
      Optional<Customer> customer =  customerRepository.findById(id);      
      return unwrapUser(customer, id);
    }

    @Override
    public Customer getCustomerByEmail(String email) {
       Optional<Customer> customer = customerRepository.findByEmail(email);
       return unwrapUser(customer, null);
    }

    @Override
    public List<Customer> getCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
       return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer, Long id) {
        Optional<Customer> custom =  customerRepository.findById(id); 
        Customer unwrappedCustomer = unwrapUser(custom, id);
        unwrappedCustomer.setFirstname(customer.getFirstname());
        unwrappedCustomer.setLastname(customer.getLastname());
        unwrappedCustomer.setPhoneNumber(customer.getPhoneNumber());
        unwrappedCustomer.setEmail(customer.getEmail());
       
        return customerRepository.save(unwrappedCustomer);
        
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    static Customer unwrapUser(Optional<Customer> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, Customer.class);
    }

     
    
}
