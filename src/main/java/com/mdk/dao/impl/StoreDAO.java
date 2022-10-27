package com.mdk.dao.impl;

import com.mdk.connection.DBConnection;
import com.mdk.dao.IStoreDAO;
import com.mdk.models.Product;
import com.mdk.models.Store;
import com.mdk.models.User;
import com.mdk.service.IStoreService;
import com.mdk.service.impl.StoreService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StoreDAO extends DBConnection implements IStoreDAO {
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;

    @Override
    public Long createStore(Store store) {
        StringBuilder sql = new StringBuilder("insert into store (name, bio, slug, ownerId, avatar, cover, " +
                "commissionId, e_wallet, createdAt, ");
        sql.append("values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
        Long id = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(String.valueOf(sql));
            ps.setString(1, store.getName());
            ps.setString(2, store.getBio());
            ps.setString(3, store.getSlug());
            ps.setLong(4, store.getOwnerID());
            ps.setString(5, store.getAvatar());
            ps.setString(6, store.getCover());
            ps.setLong(7, store.getCommissionId());
            ps.setBigDecimal(8, store.getE_wallet());
            ps.setTimestamp(9, store.getCreatedAt());

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getLong(1);
            }
            conn.commit();
            return id;
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return id;
    }
    @Override
    public List<Store> findAll() {
        String sql = "select * from store";
        List<Store> stores = new ArrayList<>();
        try {
            Store store = new Store();
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                store.setName(rs.getString("name"));
                store.setBio(rs.getString("bio"));
                store.setSlug(rs.getString("slug"));
                store.setOwnerID(rs.getLong("ownerId"));
                store.setAvatar(rs.getString("avatar"));
                store.setCover(rs.getString("cover"));
                store.setCommissionId(rs.getLong("commissionId"));
                store.setPoint(rs.getInt("point"));
                store.setRating(rs.getInt("rating"));
                store.setE_wallet(rs.getBigDecimal("e_wallet"));
                store.setCreatedAt(rs.getTimestamp("createdAt"));
                store.setUpdatedAt(rs.getTimestamp("updateAt"));

                stores.add(store);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stores;
    }
    @Override
    public Store findStoreById(long id) {
        String sql = "select * from store where _id = ?";
        Store store = new Store();
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while(rs.next()) {
                store.setName(rs.getString("name"));
                store.setBio(rs.getString("bio"));
                store.setSlug(rs.getString("slug"));
                store.setOwnerID(rs.getLong("ownerId"));
                store.setAvatar(rs.getString("avatar"));
                store.setCover(rs.getString("cover"));
                store.setCommissionId(rs.getLong("commissionId"));
                store.setPoint(rs.getInt("point"));
                store.setRating(rs.getInt("rating"));
                store.setE_wallet(rs.getBigDecimal("e_wallet"));
                store.setCreatedAt(rs.getTimestamp("createdAt"));
                store.setUpdatedAt(rs.getTimestamp("updateAt"));
            }
        } catch (SQLException e){
            e.printStackTrace();;
        }
        return store;
    }
    @Override
    public void updateStore(Store store) {
        StringBuilder sql = new StringBuilder("update store name = ?, bio = ?, slug = ?, ownerId = ?, avatar = ?, " +
                "cover = ?, " +
                "commissionId = ?,  createdAt = ?, updateAt = ? ");
        sql.append("where _id = ?");
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(String.valueOf(sql));
            ps.setString(1, store.getName());
            ps.setString(2, store.getBio());
            ps.setString(3, store.getSlug());
            ps.setLong(4, store.getOwnerID());
            ps.setString(5, store.getAvatar());
            ps.setString(6, store.getCover());
            ps.setLong(7, store.getCommissionId());
            ps.setBigDecimal(8, store.getE_wallet());
            ps.setTimestamp(9, store.getCreatedAt());
            ps.setLong(10, store.getId());
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }

    }
    @Override
    public User findOwnerInfo(long id) {
        StringBuilder sql = new StringBuilder("select firstname, lastname, email, phone, user.avatar, user.cover, " +
                "user.createdAt ");
        sql.append("from store inner join user on user._id = ?");
        User user = new User();
        IStoreService storeService = new StoreService();
        long ownerId = storeService.findStoreById(id).getOwnerID();
        try {
            conn = getConnection();
            ps = conn.prepareStatement(String.valueOf(sql));
            ps.setLong(1, ownerId);
            rs = ps.executeQuery();
            while (rs.next()) {
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setAvatar(rs.getString("avatar"));
                user.setCover(rs.getString("cover"));
                user.setCreatedAt(rs.getTimestamp("createdAt"));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }
    @Override
    public List<Long> findAllStaff(long id) {
        String sql = "select * from store_staffIds where storeId = ?";
        List<Long> listStaffId = null;
        try {
            listStaffId = new ArrayList<Long>();
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                listStaffId.add(rs.getLong("staffId"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listStaffId;
    }
    @Override
    public void insertStaff(long storeId, long userId) {
        String sql = "insert into store_staffIds(storeId, staffId)\n" +
                "values(?, ?);";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1, storeId);
            ps.setLong(2, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void deleteStore(long id) {
        String sql = "delete from store where _id = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Product> findAllProductOfStore(long id) {
        String sql = "select * from product where storeId = ?";
        List<Product> listProduct = new ArrayList<>();
        try {
            Product product = new Product();
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                product.setName(rs.getString("name"));
                product.setSlug(rs.getString("slug"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getBigDecimal("price"));
                product.setPromotionalPrice(rs.getBigDecimal("promotionalPrice"));
                product.setQuantity(rs.getInt("quantity"));
                product.setSold(rs.getInt("sold"));
                product.setCategoryId(rs.getLong("categoryId"));
                product.setStoreId(rs.getLong("storeId"));

                listProduct.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listProduct;
    }
}

