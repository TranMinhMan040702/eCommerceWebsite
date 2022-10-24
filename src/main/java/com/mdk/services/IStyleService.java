package com.mdk.services;

import com.mdk.models.Style;

import java.util.List;

public interface IStyleService {
    List<Style> findALL();
    void insert(Style style);
    void edit(Style style);
    void deleteSoft(Style style);
    void restore(Style style);
}
