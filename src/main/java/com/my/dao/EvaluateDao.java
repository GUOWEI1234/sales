package com.my.dao;

import com.my.pojo.Evaluate;

import java.util.List;

/**
 * @author GUOwei
 * 用户评论表
 * Created by GUOwei on 2018/5/2.
 */
public interface EvaluateDao {

    /**
     * 插入评论数据
     * @param evaluate
     */
    public void InsertEval(Evaluate evaluate);

    /**
     * 通过产品ID查找该产品的所以评论
     * @param product_id
     * @return
     */
    public List<Evaluate> getEvalByProId(String product_id);
}
