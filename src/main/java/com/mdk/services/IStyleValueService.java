package com.mdk.services;

import com.mdk.models.StyleValue;

import java.util.List;

public interface IStyleValueService {
    List<StyleValue> findALL();
    void insert(StyleValue styleValue);
    void edit(StyleValue styleValue);
    void deleteSoft(StyleValue styleValue);
    void restore(StyleValue styleValue);
}
