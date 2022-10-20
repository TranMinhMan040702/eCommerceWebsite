package com.mdk.dao;

import com.mdk.models.UserLevel;

import java.util.List;

public interface IUserLevelDAO {
    List<UserLevel> findALL();
    void insert(UserLevel userLevel);
    void edit(UserLevel userLevel);
    void deleteSoft(UserLevel userLevel);
    void restore(UserLevel userLevel);
}
