package com.mdk.services.impl;

import com.mdk.dao.IStoreLevelDAO;
import com.mdk.dao.impl.StoreLevelDAO;
import com.mdk.models.StoreLevel;
import com.mdk.services.IStoreLevelService;

import java.util.List;

public class StoreLevelService implements IStoreLevelService {
    IStoreLevelDAO storeLevelDAO = new StoreLevelDAO();

    @Override
    public List<StoreLevel> findALL() {
        return storeLevelDAO.findALL();
    }

    @Override
    public void insert(StoreLevel storeLevel) {
        storeLevelDAO.insert(storeLevel);
    }

    @Override
    public void edit(StoreLevel storeLevel) {
        storeLevelDAO.edit(storeLevel);
    }

    @Override
    public void deleteSoft(StoreLevel storeLevel) {
        storeLevelDAO.deleteSoft(storeLevel);
    }

    @Override
    public void restore(StoreLevel storeLevel) {
        storeLevelDAO.restore(storeLevel);
    }
}
