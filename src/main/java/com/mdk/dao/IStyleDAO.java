package com.mdk.dao;

import com.mdk.models.Style;

import java.util.List;

public interface IStyleDAO {
    List<Style> findALL();
    void insert(Style style);
    void edit(Style style);
    void deleteSoft(Style style);
    void restore(Style style);
}
