package com.my.util;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by GUOwei on 2018/4/12.
 */
public class PlanResult {

    //定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();
    //响应业务状态
    private Integer status;
    //相应消息
    private String msg;
    //相应中的数据
    private Object data;

    public static ObjectMapper getMAPPER() {
        return MAPPER;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
