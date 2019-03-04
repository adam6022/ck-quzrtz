package com.ck.quartz.controller;

import com.ruoyi.common.base.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 * 测试
 *
 * @author yd
 * @create 2019-03-01 13:37
 */
@RestController
//@Api("task")
public class taskController {

    @Autowired
    private JavaMailSender jms;


    @GetMapping("/test")
    //@ApiOperation("测试接口")
    public AjaxResult task(){
        return AjaxResult.success("测试成功");
    }

    @GetMapping("/send")
   // @ApiOperation("发送邮件测试")
    public String send(){
        //建立邮件消息
        SimpleMailMessage mainMessage = new SimpleMailMessage();
        //发送者
        mainMessage.setFrom("hzeckeylab@aliyun.com");
        //接收者
        mainMessage.setTo("zhangyadong_eie@163.com");
        //发送的标题
        mainMessage.setSubject("嗨喽");
        //发送的内容
        mainMessage.setText("hello world");
        jms.send(mainMessage);
        return "1";
    }

}
