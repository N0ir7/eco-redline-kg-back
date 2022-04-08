package com.redline.ecoredlinekgback.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UrlUtil { // 用来拼接网络地址url
    static String domain;
    static String port;
    public static String convertImgUrl(String url){
        if("null".equals(url)||url==null){
            return null;
        }
        return "http://"+domain+":"+port+url;
    }

    @Value("${server.domain}")
    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Value("${server.port}")
    public void setPort(String port) {
        this.port = port;
    }
}
