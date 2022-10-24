package com.mdk.services.impl;

import com.mdk.dao.ITransactionDAO;
import com.mdk.dao.impl.TransactionDAO;
import com.mdk.models.Transaction;
import com.mdk.services.ITransactionService;

import java.util.List;

public class TransactionService implements ITransactionService {
    ITransactionDAO transactionDAO = new TransactionDAO();

    @Override
    public List<Transaction> findAll() {
        return transactionDAO.findAll();
    }
}
