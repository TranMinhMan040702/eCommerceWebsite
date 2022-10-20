package com.mdk.dao;

import com.mdk.models.Commission;
import com.mdk.models.Delivery;

import java.util.List;

public interface ICommissionDAO {
    List<Commission> findALL();
    void insert(Commission commission);
    void edit(Commission commission);
    void deleteSoft(Commission commission);
    void restore(Commission commission);
}
