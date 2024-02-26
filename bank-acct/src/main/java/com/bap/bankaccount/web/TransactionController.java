package com.bap.bankaccount.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bap.bankaccount.entity.Transaction;
import com.bap.bankaccount.service.TransactionService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/transaction")
public class TransactionController {

    TransactionService transactionService;

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransaction(@PathVariable Long id){
        return new ResponseEntity<>(transactionService.getTransactionById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Transaction> saveTransaction(@Valid @RequestBody Transaction transaction){
        return new ResponseEntity<>(transactionService.saveTransaction(transaction), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTransaction(@PathVariable Long id){
        transactionService.deleteTransaction(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
