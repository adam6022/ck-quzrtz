package com.ck.quartz.config;

import com.ck.quartz.properties.CkQuartzProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;

import java.nio.channels.CancelledKeyException;

/**
 * 描述:
 * Email配置
 *
 * @author yd
 * @create 2019-03-01 21:23
 */
@Configuration
@Slf4j
public class EmailConfig {

    @Autowired
    private CkQuartzProperties ckQuartzProperties;

    @Bean
    public SimpleMailMessage mailMessage(){

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        //发送者
        log.info("SEND_URL:{}",ckQuartzProperties.getEmail().getUrl());
        mailMessage.setFrom(ckQuartzProperties.getEmail().getUrl());

        //接收者
        mailMessage.setTo(ckQuartzProperties.getEmail().getTo());
        //发送的标题
        mailMessage.setSubject(ckQuartzProperties.getEmail().getTitle());
        //发送的内容
        mailMessage.setText(ckQuartzProperties.getEmail().getPayload());

        return mailMessage;
    }

}
