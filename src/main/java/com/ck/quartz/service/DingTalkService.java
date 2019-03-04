package com.ck.quartz.service;

import com.ck.quartz.VO.JifangResult;
import com.dingtalk.chatbot.SendResult;

import java.io.IOException;

public interface DingTalkService {

    /**
     * 向钉钉机器人接口发送消息
     * @return
     */
    SendResult send(String payload) throws IOException;

}
