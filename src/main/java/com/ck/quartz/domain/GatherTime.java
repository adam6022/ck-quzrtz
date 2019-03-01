package com.ck.quartz.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 描述:
 *
 * @author yd
 * @create 2019-03-01 21:55
 */
@Data
@ToString
public class GatherTime {

    private static final long serialVersionUID = 1L;

    private Date lastTime;

}
