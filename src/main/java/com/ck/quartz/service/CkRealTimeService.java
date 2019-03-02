package com.ck.quartz.service;

import com.ck.quartz.VO.JifangApiStatus;
import com.ck.quartz.domain.GatherTime;


public interface CkRealTimeService {

    /**
     * 获取动环最近一次采集时间
     * @return
     */
    public GatherTime getGatherTime();

    /**
     * 获取网管最近一次采集时间
     * @return
     */
    public GatherTime getNstrongTime();

    /**
     * 监测Gt动环接口登录通讯状态
     * @return
     */
    public JifangApiStatus getGtApiStatus();

}
