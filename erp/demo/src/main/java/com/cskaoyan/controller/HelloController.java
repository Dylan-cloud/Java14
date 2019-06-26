package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: TXJ
 * @Date: 2019/6/26 21:58
 * @Version 1.0
 */
@Controller
public class HelloController {

@RequestMapping("hello")
    public String hello(){
    return "home";
}


}
