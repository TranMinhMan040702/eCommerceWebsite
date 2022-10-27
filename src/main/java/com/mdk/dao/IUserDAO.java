package com.mdk.dao;

import com.mdk.models.User;

public interface IUserDAO {
    User findUserById(long id);
}
