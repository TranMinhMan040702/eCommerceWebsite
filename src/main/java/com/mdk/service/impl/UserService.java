package com.mdk.service.impl;

import com.mdk.dao.IUserDAO;
import com.mdk.dao.impl.UserDAO;
import com.mdk.models.User;
import com.mdk.service.IUserService;

public class UserService implements IUserService {
    IUserDAO userDAO = new UserDAO();
    @Override
    public User findUserById(long id) {
        return userDAO.findUserById(id);
    }
}
