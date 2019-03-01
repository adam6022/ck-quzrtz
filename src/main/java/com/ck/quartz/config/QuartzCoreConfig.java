package com.ck.quartz.config;

import com.ck.quartz.properties.CkQuartzProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述:
 *
 * @author yd
 * @create 2019-03-01 20:53
 */
@Configuration
@EnableConfigurationProperties(CkQuartzProperties.class)
public class QuartzCoreConfig {

}
