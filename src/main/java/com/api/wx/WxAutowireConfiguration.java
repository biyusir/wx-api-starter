package com.api.wx;

import com.github.wx.api.WxRest;
import com.github.wx.api.WxRestAdapterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(WxRest.class)
@EnableConfigurationProperties(WxProperties.class)
public class WxAutowireConfiguration {
    @Autowired
    WxProperties wxProperties;

    @ConditionalOnMissingBean(WxRest.class)
    @Bean
    public WxRest wxApi() {
        return new WxRestAdapterImpl(wxProperties.getId(), wxProperties.getSecurity());
    }

}
