package com.mdk.dao;

import com.mdk.models.DetailOrdersItem;

public interface IDetailOrdersItemDAO {
    DetailOrdersItem findOneByOrderId(Long id);
}
