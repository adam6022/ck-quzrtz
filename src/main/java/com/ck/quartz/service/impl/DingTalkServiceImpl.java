package com.ck.quartz.service.impl;

import com.ck.quartz.VO.JifangResult;
import com.ck.quartz.properties.CkQuartzProperties;
import com.ck.quartz.service.DingTalkService;
import com.ruoyi.common.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 描述:
 *
 * @author yd
 * @create 2019-03-02 13:48
 */
@Service
public class DingTalkServiceImpl implements DingTalkService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CkQuartzProperties ckQuartzProperties;

    /**
     * 向钉钉机器人接口发送消息
     *
     * @return
     */
    @Override
    public JifangResult send(String payload) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        ResponseEntity<String> entity = restTemplate.postForEntity(ckQuartzProperties.getDingtalk().getWebhooktoken(), payload, String.class);
        return null;
    }
}
