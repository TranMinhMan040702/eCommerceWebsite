package com.mdk.services;

import com.mdk.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAllProductProhibited();
    List<Product> findAllProductPermited();
}
