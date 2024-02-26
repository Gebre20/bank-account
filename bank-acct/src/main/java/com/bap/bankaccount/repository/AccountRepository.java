package com.bap.bankaccount.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.bap.bankaccount.entity.Account;


public interface AccountRepository extends CrudRepository<Account, Long>{
    Optional<Account> findByAccountNumber(String accountNumber);
}
