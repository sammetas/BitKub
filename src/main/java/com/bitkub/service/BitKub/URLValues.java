package com.bitkub.service.BitKub;

import jdk.jfr.DataAmount;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
//@Data
//@ConfigurationProperties("bitkub.ticker")
public class URLValues {
    @Value("${spring.application.message: Default Hello nessage}")
    public  String message;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Value("${bitkub.ticker.url: Default nourl}")
    private  String url;

    public String getMessage() {
        return message;
    }



}
