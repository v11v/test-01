package com.tedu.sp01.service;

import com.tedu.sp01.pojo.Item;

import java.util.List;

public interface ItemService {
    /**
    * 通过订单id来获取商品列表
    */
    List<Item> getItems(String orderId);
    /**
     *在宝尊订单时
     * 减少商品库存
     */
    void decreaseNumbers(List<Item> list);
}