package com.dadalang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StartController {
    @RequestMapping("/start")       // 映射请求的路径，
    @ResponseBody                   // 将java对象转为json格式的数据。
    public String quick() {
        return "springboot quick start edition 123";
    }
}
