package com.mdk.service.impl;

import com.mdk.dao.IProductDAO;
import com.mdk.dao.impl.ProductDAO;
import com.mdk.models.Product;
import com.mdk.service.IProductService;

public class ProductService implements IProductService {
    IProductDAO productDAO = new ProductDAO();
    @Override
    public void update(Product product) {
        productDAO.update(product);
    }

    @Override
    public int totalProductByStore(long storeId) {
        return productDAO.totalProductByStore(storeId);
    }
}
