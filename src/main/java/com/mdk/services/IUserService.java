package com.mdk.services;

import com.mdk.models.User;
import com.mdk.models.User_1000;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    List<User_1000> find1000UsersLatestCreationTime();
    int totalUsers();
    List<User> topUsers();

}
