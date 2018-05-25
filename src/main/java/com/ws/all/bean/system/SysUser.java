package com.ws.all.bean.system;

import lombok.Data;

/**
 * @Author: wangsaisoon
 * @Date: 2018/5/15 15:52
 * @Description: 系统用户
 */
@Data
public class SysUser {
    private String id;
    private String username;
    private String password;

    public SysUser() {
    }

    public SysUser(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
