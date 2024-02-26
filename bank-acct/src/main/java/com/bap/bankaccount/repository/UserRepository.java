package com.bap.bankaccount.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.bap.bankaccount.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{

    Optional<User> findByUsername(String username);
} 
