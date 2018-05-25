package com.ws.all.enums;

import lombok.Getter;

/**
 * @Author: wangsaisoon
 * @Date: 2018/5/23 12:14
 * @Description: 异常的枚举
 */
@Getter
public enum ExceptionEnum {
    ID_IS_NULL(1, "id为null"),
    ;

    private Integer code;
    private String msg;

    ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    ExceptionEnum() {

    }
}
