package com.mdk.dao.impl;

import com.mdk.connection.DBConnection;
import com.mdk.dao.ITransactionDAO;
import com.mdk.models.Transaction;
import com.mdk.models.UserLevel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO extends DBConnection implements ITransactionDAO {

    @Override
    public List<Transaction> findAll() {
        String sql = "SELECT userId, storeId, isUp, amount FROM transaction";
        List<Transaction> transactions = new ArrayList<Transaction>();
        try {
            Connection getConnection = super.getConnection();
            PreparedStatement pStatement = getConnection.prepareStatement(sql);
            ResultSet resultSet = pStatement.executeQuery();
            while(resultSet.next()) {
                Transaction transaction = new Transaction();
                transaction.setUserId(resultSet.getLong("userId"));
                transaction.setStoreId(resultSet.getLong("storeId"));
                transaction.setUp(resultSet.getBoolean("isUp"));
                transaction.setAmount(resultSet.getBigDecimal("amount"));
                transactions.add(transaction);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transactions;
    }
}
