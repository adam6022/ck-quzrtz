package com.ck.quartz.config;

import com.ck.quartz.properties.CkQuartzProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

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
