package com.boot.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


/**
 * @DATE 2019/11/4 20:33
 * @Description 测试请求类
 * @Author Tian Daguang
 **/
@RestController
@RequestMapping("consumer")
@Slf4j
public class DemoController {
    @Autowired
    RestTemplate restTemplate;


    @NacosValue(value = "${name:tdg}", autoRefreshed = true)
    private String name;

    @GetMapping(path = "send")
    public String send() {
        log.info("可以用了！！！---name:{}", name);
        Map<String, Object> mp = new HashMap<>();
        mp.put("code", name);
        return JSON.toJSONString(mp);
    }

    @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
    public String echo(@PathVariable String str) {
        return restTemplate.getForObject("http://cloud-provider/provider/echo/" + str, String.class);
    }
}
