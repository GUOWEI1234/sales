package com.my.dao;

import com.my.pojo.Buy;

/**
 * @author
 * Created by GUOwei on 2018/5/8.
 */
public interface BuyDao {
    /**
     * 插入用户购买记录
     * @param buy
     */
    public void insertBuy(Buy buy);
}
