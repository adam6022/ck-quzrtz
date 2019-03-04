package com.ck.quartz.service.impl;

import com.ck.quartz.VO.JifangApiStatus;
import com.ck.quartz.VO.JifangResult;
import com.ck.quartz.domain.GatherTime;
import com.ck.quartz.mapper.CkRealTimeMapper;
import com.ck.quartz.properties.CkQuartzProperties;
import com.ck.quartz.service.CkRealTimeService;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 描述:
 *
 * @author yd
 * @create 2019-03-01 21:51
 */
@Service
public class CkRealTimeServiceImpl implements CkRealTimeService {

    @Autowired
    private CkRealTimeMapper ckRealTimeMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CkQuartzProperties ckQuartzProperties;

    /**
     * 获取最近一次采集时间
     *
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public GatherTime getGatherTime() {
        return ckRealTimeMapper.getGatherTime();
    }

    /**
     * 获取网管最近一次采集时间
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public GatherTime getNstrongTime(){
        return ckRealTimeMapper.getNstrongTime();
    }

    /**
     * 监测Gt动环接口登录通讯状态
     *
     * @return
     */
    @Override
    public JifangApiStatus getGtApiStatus() {
        ResponseEntity<JifangResult> response = restTemplate.
                getForEntity(ckQuartzProperties.getJifang().getMonitorApi(), JifangResult.class);
        JifangResult result = response.getBody();
        JifangApiStatus status = new JifangApiStatus();

        status.setIndexCount(result.getMap().get("indexCount").toString());
        status.setPeriodCount(result.getMap().get("periodCount").toString());
        status.setRealtimeCount(result.getMap().get("realtimeCount").toString());
        status.setNstrongDateStatus(result.getMap().get("nstrongDateStatus").toString());
        status.setPowerDateStatus(result.getMap().get("powerDateStatus").toString());
        status.setMessageDateStatus(result.getMap().get("messageDateStatus").toString());

        return status;
    }
}
