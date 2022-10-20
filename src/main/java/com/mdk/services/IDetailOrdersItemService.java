package com.mdk.services;

import com.mdk.models.DetailOrdersItem;

public interface IDetailOrdersItemService {
    DetailOrdersItem findOneByOrderId(Long id);

}
