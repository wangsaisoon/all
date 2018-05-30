package com.ws.all.bean.webscoket;

import lombok.Data;

/**
 * @Author: wangsaisoon
 * @Date: 2018/5/25 11:48
 * @Description: 服务端发送消息实体
 */
@Data
public class ServerMessage {

    private String responseMessage;

    public ServerMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
