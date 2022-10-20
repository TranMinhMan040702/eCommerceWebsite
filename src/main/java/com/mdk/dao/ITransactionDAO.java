package com.mdk.dao;

import com.mdk.models.Transaction;

import java.util.List;

public interface ITransactionDAO {
    List<Transaction> findAll();
}
