package com.bap.bankaccount.repository;

import org.springframework.data.repository.CrudRepository;

import com.bap.bankaccount.entity.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Long>{

    
} 
