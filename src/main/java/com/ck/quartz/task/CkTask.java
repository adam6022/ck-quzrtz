package com.ck.quartz.task;

import com.ck.quartz.domain.GatherTime;
import com.ck.quartz.service.CkRealTimeService;
import com.ck.quartz.service.ISysJobLogService;
import com.ck.quartz.util.SpringContextUtil;
import com.ruoyi.common.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.Date;


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
    //private final static CkRealTimeService ckRealTimeService = SpringContextUtil.getBean(CkRealTimeService.class);

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
    public void getGatherTime() {
        log.info("GatherTime:{}");
        GatherTime gatherTime = ckRealTimeService.getGatherTime();
        log.info("GatherTime:{}", gatherTime);
        mailMessage.setText("玄武动环指标最新采集时间：" + DateUtils.parseDateToStr("yyyy-MM-dd HH:mm:ss", gatherTime.getLastTime()
        )+"\n"+"当前告警数: 0 "+"\n"+ new Date());
        jms.send(mailMessage);
    }

}
