package com.mdk.services.impl;

import com.mdk.dao.ICommissionDAO;
import com.mdk.dao.impl.CommissionDAO;
import com.mdk.models.Commission;
import com.mdk.services.ICommissionService;

import java.util.List;

public class CommissionService implements ICommissionService {
    ICommissionDAO commissionDAO = new CommissionDAO();

    @Override
    public List<Commission> findALL() {
        return commissionDAO.findALL();
    }

    @Override
    public void insert(Commission commission) {
        commissionDAO.insert(commission);
    }

    @Override
    public void edit(Commission commission) {
        commissionDAO.edit(commission);
    }

    @Override
    public void deleteSoft(Commission commission) {
        commissionDAO.deleteSoft(commission);
    }

    @Override
    public void restore(Commission commission) {
        commissionDAO.restore(commission);
    }
}
