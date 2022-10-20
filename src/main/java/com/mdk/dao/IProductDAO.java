package com.mdk.dao;

import com.mdk.models.Product;

import java.util.List;

public interface IProductDAO {
    List<Product> findAllProductProhibited();
    List<Product> findAllProductPermited();
}
