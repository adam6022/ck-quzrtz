package com.ck.quartz.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 描述:
 *
 * @author yd
 * @create 2019-03-01 20:59
 */
@ConfigurationProperties(prefix = "ck.quartz")
public class CkQuartzProperties {

    private EmailProperties email = new EmailProperties();

    public EmailProperties getEmail() {
        return email;
    }

    public void setEmail(EmailProperties email) {
        this.email = email;
    }
}
