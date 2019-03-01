package com.ck.quartz.properties;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;

/**
 * 描述:
 *
 * @author yd
 * @create 2019-03-01 20:12
 */
@Data
@Slf4j
public class EmailProperties {

    private String url;

    private String to;

    private String title;

    private String payload;


    public SimpleMailMessage mailMessage(SimpleMailMessage mailMessage){
        //发送者
        log.info("SEND_URL:{}",url);
        mailMessage.setFrom(url);

        //接收者
        mailMessage.setTo(to);
        //发送的标题
        mailMessage.setSubject(title);
        //发送的内容
        mailMessage.setText(payload);

        return mailMessage;
    }

}
