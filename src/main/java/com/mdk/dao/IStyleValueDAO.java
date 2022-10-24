package com.mdk.dao;

import com.mdk.models.StyleValue;

import java.util.List;

public interface IStyleValueDAO {
    List<StyleValue> findALL();
    void insert(StyleValue styleValue);
    void edit(StyleValue styleValue);
    void deleteSoft(StyleValue styleValue);
    void restore(StyleValue styleValue);
}
