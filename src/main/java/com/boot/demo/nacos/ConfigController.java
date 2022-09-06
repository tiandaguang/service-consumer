package com.boot.demo.nacos;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("config")
@Slf4j
public class ConfigController {
    @NacosInjected
    private ConfigService configService;


    @RequestMapping(value = "publish", method = RequestMethod.GET)
    public void publish() throws NacosException {
        configService.publishConfig("tdg", "DEFAULT_GROUP", "9527");
    }
}
