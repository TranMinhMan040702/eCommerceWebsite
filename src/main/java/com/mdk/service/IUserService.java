package com.mdk.service;

import com.mdk.models.User;

public interface IUserService {
    User findUserById(long id);
}
