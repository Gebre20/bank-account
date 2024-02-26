package com.bap.bankaccount.service;

import java.util.List;

import com.bap.bankaccount.entity.Transaction;

public interface TransactionService {
    
    Transaction getTransactionById(Long id);
    List<Transaction> getTransactions();
    Transaction saveTransaction(Transaction transaction);
    Transaction updateTransaction(Transaction transaction, Long id);
    void deleteTransaction(Long id);

}
