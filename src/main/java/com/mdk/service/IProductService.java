package com.mdk.service;

import com.mdk.models.Product;

public interface IProductService {
    void update (Product product);
    int totalProductByStore(long storeId);
}
