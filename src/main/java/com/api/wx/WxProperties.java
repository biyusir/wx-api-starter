package com.api.wx;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "wx.small.program")
@Data
public class WxProperties {
    private String id;
    private String security;
}
