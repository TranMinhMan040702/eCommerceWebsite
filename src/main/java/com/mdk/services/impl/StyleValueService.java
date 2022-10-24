package com.mdk.services.impl;

import com.mdk.dao.IStyleValueDAO;
import com.mdk.dao.impl.StyleValueDAO;
import com.mdk.models.StyleValue;
import com.mdk.services.IStyleValueService;

import java.util.List;

public class StyleValueService implements IStyleValueService {
    IStyleValueDAO styleValueDAO = new StyleValueDAO();

    @Override
    public List<StyleValue> findALL() {
        return styleValueDAO.findALL();
    }

    @Override
    public void insert(StyleValue styleValue) {
        styleValueDAO.insert(styleValue);
    }

    @Override
    public void edit(StyleValue styleValue) {
        styleValueDAO.edit(styleValue);
    }

    @Override
    public void deleteSoft(StyleValue styleValue) {
        styleValueDAO.deleteSoft(styleValue);
    }

    @Override
    public void restore(StyleValue styleValue) {
        styleValueDAO.restore(styleValue);
    }
}
