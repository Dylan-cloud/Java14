package com.cskaoyan.controller;

import com.cskaoyan.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: TXJ
 * @Date: 2019/6/26 23:14
 * @Version 1.0
 */
@Controller
@RequestMapping("/custom")
public class CustomController {

    @Autowired
    private CustomService customService;

    @RequestMapping("/find")
    public String find() {
        return "custom_list";
    }

}
