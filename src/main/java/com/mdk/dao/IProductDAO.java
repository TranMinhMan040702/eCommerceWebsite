package com.mdk.dao;

import com.mdk.models.Product;

public interface IProductDAO {
    void update (Product product);
    int totalProductByStore(long storeId);
}
