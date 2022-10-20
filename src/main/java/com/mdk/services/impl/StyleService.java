package com.mdk.services.impl;

import com.mdk.dao.IStyleDAO;
import com.mdk.dao.impl.StyleDAO;
import com.mdk.models.Style;
import com.mdk.services.IStyleService;

import java.util.List;

public class StyleService implements IStyleService {
    IStyleDAO styleDAO = new StyleDAO();

    @Override
    public List<Style> findALL() {
        return styleDAO.findALL();
    }

    @Override
    public void insert(Style style) {
        styleDAO.insert(style);
    }

    @Override
    public void edit(Style style) {
        styleDAO.edit(style);
    }

    @Override
    public void deleteSoft(Style style) {
        styleDAO.deleteSoft(style);
    }

    @Override
    public void restore(Style style) {
        styleDAO.restore(style);
    }
}
