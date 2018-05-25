package com.ws.all.exception;

import com.ws.all.enums.ExceptionEnum;

/**
 * @Author: wangsaisoon
 * @Date: 2018/5/23 11:56
 * @Description: 异常处理
 */
public class MyException extends RuntimeException {

    private Integer  code;

    public MyException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
    }

    public MyException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
