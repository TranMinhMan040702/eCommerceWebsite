package com.mdk.services;

import com.mdk.models.Transaction;

import java.util.List;

public interface ITransactionService {
    List<Transaction> findAll();
}
