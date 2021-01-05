package com.spring.service;

import com.spring.entity.Transaction;
import com.spring.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Collection;
import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepo transactionRepo;

    public Transaction createNewTransaction(String itemId, Transaction.Type type, float price){
        Transaction transaction = new Transaction();
        transaction.setId(UUID.randomUUID().toString());
        transaction.setType(type);
        transaction.setIncome(price);
        transaction.setItemId(itemId);
        Calendar calendar = Calendar.getInstance();
        transaction.setPurchaseDate(calendar.getTime());
        return transaction;
    }

    public boolean insertNewTransaction(Transaction transaction) {
        //todo validari, schimbare tip returnat, all the good stuff
        transactionRepo.insertNewTransaction(transaction);
        return true;
    }

    public Collection<Transaction> getAllTransactions() {
        return transactionRepo.getAllTransactions();
    }
}
