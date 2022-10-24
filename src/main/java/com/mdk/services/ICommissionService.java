package com.mdk.services;

import com.mdk.models.Commission;

import java.util.List;

public interface ICommissionService {
    List<Commission> findALL();
    void insert(Commission commission);
    void edit(Commission commission);
    void deleteSoft(Commission commission);
    void restore(Commission commission);
}
