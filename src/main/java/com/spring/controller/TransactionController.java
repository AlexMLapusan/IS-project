package com.spring.controller;

import com.spring.entity.Transaction;
import com.spring.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("req/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Collection<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }
}
