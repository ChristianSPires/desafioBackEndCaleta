package com.challenge.caleta.service;

import com.challenge.caleta.repository.TransactionRepository;

public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
}
