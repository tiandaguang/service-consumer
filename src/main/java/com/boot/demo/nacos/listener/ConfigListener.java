package com.boot.demo.nacos.listener;

import com.alibaba.nacos.api.config.annotation.NacosConfigListener;
import org.springframework.stereotype.Component;

@Component
public class ConfigListener {
    @NacosConfigListener(dataId = "tdg")
    public void onMessage(String config) {
        System.out.println("监听到的配置==" + config);
    }
}
