package com.mdk.services;

import com.mdk.models.UserLevel;

import java.util.List;

public interface IUserLevelService {
    List<UserLevel> findALL();
    void insert(UserLevel userLevel);
    void edit(UserLevel userLevel);
    void deleteSoft(UserLevel userLevel);
    void restore(UserLevel userLevel);
}
