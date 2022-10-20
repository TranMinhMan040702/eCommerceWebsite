package com.mdk.services.impl;

import com.mdk.dao.IUserLevelDAO;
import com.mdk.dao.impl.UserLevelDAO;
import com.mdk.models.UserLevel;

import java.util.List;

public class UserLevelService implements IUserLevelDAO {
    IUserLevelDAO userLevelDAO = new UserLevelDAO();

    @Override
    public List<UserLevel> findALL() {
        return userLevelDAO.findALL();
    }

    @Override
    public void insert(UserLevel userLevel) {
        userLevelDAO.insert(userLevel);
    }

    @Override
    public void edit(UserLevel userLevel) {
        userLevelDAO.edit(userLevel);
    }

    @Override
    public void deleteSoft(UserLevel userLevel) {
        userLevelDAO.deleteSoft(userLevel);
    }

    @Override
    public void restore(UserLevel userLevel) {
        userLevelDAO.restore(userLevel);
    }
}
