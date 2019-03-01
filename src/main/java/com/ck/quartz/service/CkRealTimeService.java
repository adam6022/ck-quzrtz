package com.ck.quartz.service;

import com.ck.quartz.domain.GatherTime;


public interface CkRealTimeService {

    /**
     * 获取最近一次采集时间
     * @return
     */
    public GatherTime getGatherTime();

}
