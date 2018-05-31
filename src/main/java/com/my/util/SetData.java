package com.my.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * @author guo
 * Created by GUOwei on 2018/5/7.
 */
public class SetData {

    /**
     * 修改从数据库中取出的时间timestamp-->String
     */
    public static String setData(Timestamp data){
        String StrData = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        StrData = sdf.format(data);
        return StrData;
    }
}
