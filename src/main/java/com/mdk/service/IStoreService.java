package com.mdk.service;

import com.mdk.models.Product;
import com.mdk.models.Store;
import com.mdk.models.User;

import java.util.List;

public interface IStoreService {
    Long createStore (Store store);
    List<Store> findAll ();
    Store findStoreById(long id);
    void updateStore (Store store);
    User findOwnerInfo(long id);
    List<User> findAllStaff(long id);
    void insertStaff(long storeId, long userId);
    void deleteStore(long id);
    List<Product> findAllProductOfStore(long id);
}
