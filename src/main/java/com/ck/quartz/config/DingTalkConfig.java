package com.ck.quartz.config;

import com.dingtalk.chatbot.DingtalkChatbotClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述:
 * 钉钉接口配置
 * @author yd
 * @create 2019-03-04 10:22
 */
@Configuration
public class DingTalkConfig {

   @Bean
   public DingtalkChatbotClient dingtalkChatbotClient(){
       return new DingtalkChatbotClient();
   }

}
