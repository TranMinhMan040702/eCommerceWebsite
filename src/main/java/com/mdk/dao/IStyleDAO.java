package com.mdk.dao;

import com.mdk.models.StyleModel;

import java.util.List;

public interface IStyleDAO {
    List<StyleModel> findAll();
}
