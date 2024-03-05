package com.bap.bankaccount.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bap.bankaccount.entity.Account;
import com.bap.bankaccount.service.AccountService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/account")
//@CrossOrigin(origins = "http://localhost:3000")
public class AccountController {

    AccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable Long id){
        return new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<Account> saveAccount(@Valid @RequestBody Account account, @PathVariable Long customerId){
        return new ResponseEntity<>(accountService.saveAccount(account, customerId), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
