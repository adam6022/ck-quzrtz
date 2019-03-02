package com.ck.quartz.service;

import com.ck.quartz.VO.JifangResult;

public interface DingTalkService {

    /**
     * 向钉钉机器人接口发送消息
     * @return
     */
    JifangResult send(String payload);

}
