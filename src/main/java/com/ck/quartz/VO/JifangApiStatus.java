package com.ck.quartz.VO;

import lombok.Data;

/**
 * 描述:
 * Jifang系统监测指标
 * @author yd
 * @create 2019-03-02 09:58
 */
@Data
public class JifangApiStatus {

    private String realtimeCount;

    private String indexCount;

    private String periodCount;

    private String nstrongDateStatus;

    private String powerDateStatus;

    private String messageDateStatus;

    private String GraphDateStatus;

}
