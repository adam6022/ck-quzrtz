package com.ck.quartz.service.impl;

import com.ck.quartz.VO.JifangResult;
import com.ck.quartz.properties.CkQuartzProperties;
import com.ck.quartz.service.DingTalkService;
import com.dingtalk.chatbot.DingtalkChatbotClient;
import com.dingtalk.chatbot.SendResult;
import com.dingtalk.chatbot.message.ActionButtonStyle;
import com.dingtalk.chatbot.message.ActionCardAction;
import com.dingtalk.chatbot.message.ActionCardMessage;
import com.dingtalk.chatbot.message.TextMessage;
import com.ruoyi.common.json.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * 描述:
 *
 * @author yd
 * @create 2019-03-02 13:48
 */
@Service
@Slf4j
public class DingTalkServiceImpl implements DingTalkService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CkQuartzProperties ckQuartzProperties;

    @Autowired
    private DingtalkChatbotClient dingtalkChatbotClient;

    /**
     * 向钉钉机器人接口发送消息
     *
     * @return
     */
    @Override
    public SendResult send(String payload) throws IOException {
        TextMessage message = new TextMessage(payload);
        SendResult result = dingtalkChatbotClient.send(ckQuartzProperties.getDingtalk().getWebhooktoken(), message);
        log.info("【钉钉机器人发送消息响应】:{}", result);
        return result;
    }
}
