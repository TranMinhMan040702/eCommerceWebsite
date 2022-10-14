package com.mdk.dao.impl;

import com.mdk.connection.DBConnection;
import com.mdk.dao.IStyleDAO;
import com.mdk.models.StyleModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StyleDAO extends DBConnection {

    public static void main(String[] args) {
        System.out.print(findAll());
    }

    public static List<StyleModel> findAll() {
        String sql = "select * from style";
        List<StyleModel> styles = new ArrayList<StyleModel>();
        try {
            Connection getConnection = getConnection();
            PreparedStatement pStatement = getConnection.prepareStatement(sql);
            ResultSet resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                StyleModel styleModel = new StyleModel();
                styleModel.setName(resultSet.getString("name"));
                styleModel.setIdDeleted(resultSet.getString("idDeleted").isEmpty());
                styles.add(styleModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return styles;
    }


}
