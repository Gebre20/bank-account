package com.bap.bankaccount.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bap.bankaccount.entity.Transaction;
import com.bap.bankaccount.exception.EntityNotFoundException;
import com.bap.bankaccount.repository.TransactionRepository;


import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class TransactionServiceImplementation implements TransactionService{

    private TransactionRepository transactionRepository;

    @Override
    public Transaction getTransactionById(Long id) {
      Optional<Transaction> transaction =  transactionRepository.findById(id);      
      return unwrapUser(transaction, id);
    }

    

    @Override
    public List<Transaction> getTransactions() {
        return (List<Transaction>) transactionRepository.findAll();
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
       return transactionRepository.save(transaction);
    }

    @Override
    public Transaction updateTransaction(Transaction transaction, Long id) {
        Optional<Transaction> custom =  transactionRepository.findById(id); 
        Transaction unwrappedTransaction = unwrapUser(custom, id);
        unwrappedTransaction.setType(transaction.getType());
        unwrappedTransaction.setAmount(transaction.getAmount());
        unwrappedTransaction.setDescription(transaction.getDescription());
       
        return transactionRepository.save(unwrappedTransaction);
        
    }

    @Override
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    static Transaction unwrapUser(Optional<Transaction> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, Transaction.class);
    }

     
    
}

