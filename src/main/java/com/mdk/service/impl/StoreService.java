package com.mdk.service.impl;

import com.mdk.dao.IStoreDAO;
import com.mdk.dao.IUserDAO;
import com.mdk.dao.impl.StoreDAO;
import com.mdk.dao.impl.UserDAO;
import com.mdk.models.Product;
import com.mdk.models.Store;
import com.mdk.models.User;
import com.mdk.service.IStoreService;
import com.mdk.service.IUserService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class StoreService implements IStoreService {
    private IStoreDAO storeDAO = new StoreDAO();
    @Override
    public Long createStore(Store store) {
        store.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        return storeDAO.createStore(store);
    }

    @Override
    public List<Store> findAll() {
        return storeDAO.findAll();
    }

    @Override
    public Store findStoreById(long id) {
        return storeDAO.findStoreById(id);
    }

    @Override
    public void updateStore(Store store) {
        store.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        storeDAO.updateStore(store);
    }

    @Override
    public User findOwnerInfo(long id) {
        return storeDAO.findOwnerInfo(id);
    }

    @Override
    public List<User> findAllStaff(long id) {
        IUserDAO userDAO = new UserDAO();
        List<User> listStaff = new ArrayList<>();
        List<Long> listId = storeDAO.findAllStaff(id);
        for (int i = 0; i < listId.size(); i++) {
            listStaff.add(userDAO.findUserById(listId.get((i))));
        }
        return listStaff;
    }
    @Override
    public void insertStaff(long storeId, long userId) {
        storeDAO.insertStaff(storeId, userId);
    }
    @Override
    public void deleteStore(long id) {
        storeDAO.deleteStore(id);
    }

    @Override
    public List<Product> findAllProductOfStore(long id) {
        return storeDAO.findAllProductOfStore(id);
    }
}
