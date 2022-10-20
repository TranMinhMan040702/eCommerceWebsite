package com.mdk.dao;

import com.mdk.models.Category;

import java.util.List;

public interface ICategoryDAO {
    List<Category> findALL();
    void insert(Category category);
    void edit(Category category);
    void deleteSoft(Category category);
    void restore(Category category);
}
