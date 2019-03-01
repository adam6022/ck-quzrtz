package com.ck.quartz.mapper;

import com.ck.quartz.domain.GatherTime;
import com.ruoyi.common.base.AjaxResult;
import org.apache.ibatis.annotations.Mapper;

/**
 * 描述:
 *
 * @author yd
 * @create 2019-03-01 21:52
 */
@Mapper
public interface CkRealTimeMapper {

    public GatherTime getGatherTime();

}
