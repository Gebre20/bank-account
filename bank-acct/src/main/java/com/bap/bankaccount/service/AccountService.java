package com.bap.bankaccount.service;

import java.util.List;

import com.bap.bankaccount.entity.Account;

public interface AccountService {

    Account getAccountById(Long id);
    List<Account> getAccounts();
    Account saveAccount(Account account, Long customerId);
    Account updateAccount(Account account, Long id);
    void deleteAccount(Long id);
    
} 
