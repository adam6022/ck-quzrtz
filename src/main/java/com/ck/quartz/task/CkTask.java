package com.ck.quartz.task;

import com.ck.quartz.VO.JifangApiStatus;
import com.ck.quartz.VO.JifangResult;
import com.ck.quartz.domain.GatherTime;
import com.ck.quartz.enums.JiFangResultEnum;
import com.ck.quartz.service.CkRealTimeService;
import com.ck.quartz.service.DingTalkService;
import com.dingtalk.chatbot.DingtalkChatbotClient;
import com.dingtalk.chatbot.SendResult;
import com.dingtalk.chatbot.message.ActionButtonStyle;
import com.dingtalk.chatbot.message.ActionCardAction;
import com.dingtalk.chatbot.message.ActionCardMessage;
import com.ruoyi.common.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;


/**
 * 描述:
 * 任务列表
 * @author yd
 * @create 2019-03-01 16:49
 */
@Component("ckTask")
@Slf4j
public class CkTask {

    @Autowired
    private JavaMailSender jms;

    @Autowired
    private SimpleMailMessage mailMessage;

    @Autowired
    private CkRealTimeService ckRealTimeService;

    @Autowired
    private DingTalkService dingTalkService;




    /**
     * 有参方法任务
     * @param params
     */
    public void ckParams(String params)
    {
        log.info("这是一条由Ck任务发送的有参消息：{}", params);
    }

    /**
     * 无参方法任务
     */
    public void ckNoParams() {
        jms.send(mailMessage);
        log.info("这是一条由Ck任务发送的无参消息");

    }

    /**
     * 获取CK系统最近一次采集动环时间
     */
    public void getGatherTime() throws IOException {
        log.info("GatherTime:{}");
        GatherTime gatherTime = ckRealTimeService.getGatherTime();

        GatherTime nstrongTime = ckRealTimeService.getNstrongTime();
        log.info("nstrongTime:{}", nstrongTime);


        JifangApiStatus status = null;
        try {
            status = ckRealTimeService.getGtApiStatus();
        } catch (Exception e) {
            log.error("【JiFang系统服务监控接口】连接失败，{}", e.getMessage());
        }

        StringBuffer sb = new StringBuffer();

            sb.append("玄武动环最新指标采集时间：")
                    .append(DateUtils.parseDateToStr("yyyy-MM-dd HH:mm:ss", gatherTime.getLastTime()))
                    .append("\n")
                    .append("玄武网管最新指标采集时间：")
                    .append(DateUtils.parseDateToStr("yyyy-MM-dd HH:mm:ss", nstrongTime.getLastTime()))
                    .append("\n");
        if (status != null) {
            sb.append("网管数据接口：")
                    .append(JiFangResultEnum.getStatus(status.getNstrongDateStatus()))
                    .append("\n")
                    .append("动环数据接口：")
                    .append(JiFangResultEnum.getStatus(status.getPowerDateStatus()))
                    .append("\n")
                    .append("短信告警接口：")
                    .append(JiFangResultEnum.getStatus(status.getMessageDateStatus()))
                    .append("\n")
                    .append("动环采集轮数: ")
                    .append(status.getIndexCount()).append("轮")
                    .append("\n")
                    .append("动环采集周期：")
                    .append(status.getPeriodCount()).append("周期")
                    .append("\n")
                    .append("动环最新采集更新指标数：")
                    .append(status.getRealtimeCount());
        }else {
            sb.append("\n\n【信息】JiFang系统服务监控接口通讯异常");
        }





        mailMessage.setText(sb.toString());
        //log.info("【发送邮件】,信息：{}", mailMessage);
        //jms.send(mailMessage);
        dingTalkService.send(sb.toString());
    }

    public void monitorRunStatus() throws IOException {
        log.info("开始监控运行状态");
        JifangApiStatus status = null;
        try {
            status = ckRealTimeService.getGtApiStatus();
        } catch (Exception e) {
            log.error("【JiFang系统服务监控接口】连接失败，{}", e.getMessage());
            dingTalkService.send("【JiFang系统服务监控接口】连接失败,请检查JiFang系统是否正常运行");
        }
        if (status.getPowerDateStatus().equals("false")){
            dingTalkService.send("【动环数据采集】监测到数据接口未运行，正在尝试重新启动");
            JifangResult jifangResult = ckRealTimeService.startPowerDataService();
            log.info(jifangResult.getMessage());
            log.info("【动环数据采集】等待运行结果");
            try {
                Thread.sleep(5*1000);
                status = ckRealTimeService.getGtApiStatus();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (status.getPowerDateStatus().equals("true")){
                dingTalkService.send("【动环数据采集】重新启动成功，服务运行中");
            }
        }
    }


}
