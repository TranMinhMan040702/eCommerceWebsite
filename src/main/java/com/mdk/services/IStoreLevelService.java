package com.mdk.services;

import com.mdk.models.StoreLevel;

import java.util.List;

public interface IStoreLevelService {
    List<StoreLevel> findALL();
    void insert(StoreLevel storeLevel);
    void edit(StoreLevel storeLevel);
    void deleteSoft(StoreLevel storeLevel);
    void restore(StoreLevel storeLevel);
}
