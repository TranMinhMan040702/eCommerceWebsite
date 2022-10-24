
package com.mdk.dao.impl;

import com.mdk.connection.DBConnection;
import com.mdk.dao.IStoreDAO;
import com.mdk.models.Store;
import com.mdk.models.Store_1000;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StoreDAO extends DBConnection implements IStoreDAO {
    @Override
    public List<Store> findAll() {
        String sql = "SELECT * FROM store";
        List<Store> stores = new ArrayList<Store>();
        try {
            Connection getConnection = super.getConnection();
            PreparedStatement pStatement = getConnection.prepareStatement(sql);
            ResultSet resultSet = pStatement.executeQuery();
            while(resultSet.next()) {
                Store store = new Store();
                store.setName(resultSet.getString("name"));
                store.setBio(resultSet.getString("bio"));
                store.setOwnerID(resultSet.getLong("ownerId"));
                store.setPoint(resultSet.getInt("point"));
                store.setRating(resultSet.getInt("rating"));
                stores.add(store);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stores;
    }

    @Override
    public List<Store_1000> find1000StoresLatestCreationTime() {
        String sql = "SELECT COUNT(_id) as quantity, point FROM (" +
                "SELECT TOP 1000 * FROM store) GROUP BY point ORDER BY createdAt DESC";
        List<Store_1000> stores_1000 = new ArrayList<Store_1000>();
        try {
            Connection getConnection = super.getConnection();
            PreparedStatement pStatement = getConnection.prepareStatement(sql);
            ResultSet resultSet = pStatement.executeQuery();
            while(resultSet.next()) {
                Store_1000 store = new Store_1000();
                store.setQuatity_group(resultSet.getInt("quantity"));
                store.setPoint(resultSet.getInt("point"));
                stores_1000.add(store);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stores_1000;
    }

    @Override
    public int totalStores() {
        String sql = "SELECT COUNT(_id) as total FROM store";
        int result = 0;
        try {
            Connection getConnection = super.getConnection();
            PreparedStatement pStatement = getConnection.prepareStatement(sql);
            result = pStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Store> topStores() {
        String sql = "SELECT TOP 10 * FROM store ORDER BY point DESC";
        List<Store> stores = new ArrayList<Store>();
        try {
            Connection getConnection = super.getConnection();
            PreparedStatement pStatement = getConnection.prepareStatement(sql);
            ResultSet resultSet = pStatement.executeQuery();
            while(resultSet.next()) {
                Store store = new Store();
                store.setName(resultSet.getString("name"));
                store.setBio(resultSet.getString("bio"));
                store.setOwnerID(resultSet.getLong("ownerId"));
                store.setPoint(resultSet.getInt("point"));
                store.setRating(resultSet.getInt("rating"));
                stores.add(store);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stores;
    }

}
