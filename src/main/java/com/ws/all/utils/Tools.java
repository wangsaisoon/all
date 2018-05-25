package com.ws.all.utils;

import java.util.UUID;

/**
 * @Author: wangsaisoon
 * @Date: 2018/5/19 12:25
 * @Description:
 */
public class Tools {

    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
