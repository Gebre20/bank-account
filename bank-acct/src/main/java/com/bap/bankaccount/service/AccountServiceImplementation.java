package com.bap.bankaccount.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bap.bankaccount.entity.Account;
import com.bap.bankaccount.exception.EntityNotFoundException;
import com.bap.bankaccount.repository.AccountRepository;


import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class AccountServiceImplementation implements AccountService{

    private AccountRepository accountRepository;

    @Override
    public Account getAccountById(Long id) {
      Optional<Account> account =  accountRepository.findById(id);      
      return unwrapUser(account, id);
    }

   

    @Override
    public List<Account> getAccounts() {
        return (List<Account>) accountRepository.findAll();
    }

    @Override
    public Account saveAccount(Account account) {
       return accountRepository.save(account);
    }

    @Override
    public Account updateAccount(Account account, Long id) {
        Optional<Account> custom =  accountRepository.findById(id); 
        Account unwrappedAccount = unwrapUser(custom, id);
        unwrappedAccount.setAccountNumber(account.getAccountNumber());
        unwrappedAccount.setBalance(account.getBalance());
        unwrappedAccount.setCsv(account.getCsv());
       
        return accountRepository.save(unwrappedAccount);
        
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    static Account unwrapUser(Optional<Account> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, Account.class);
    }

     
    
}

