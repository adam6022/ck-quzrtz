package com.ck.quartz.service.impl;

import com.ck.quartz.domain.GatherTime;
import com.ck.quartz.mapper.CkRealTimeMapper;
import com.ck.quartz.service.CkRealTimeService;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
