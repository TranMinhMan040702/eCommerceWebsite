package com.mdk.services.impl;

import com.mdk.dao.IUserDAO;
import com.mdk.dao.impl.UserDAO;
import com.mdk.models.User;
import com.mdk.models.User_1000;
import com.mdk.services.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {
    IUserDAO userDao = new UserDAO();

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public List<User_1000> find1000UsersLatestCreationTime() {
        return userDao.find1000UsersLatestCreationTime();
    }

    @Override
    public int totalUsers() {
        return userDao.totalUsers();
    }

    @Override
    public List<User> topUsers() {
        return userDao.topUsers();
    }
}
