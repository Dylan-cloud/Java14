package com.cskaoyan.controller;

import com.cskaoyan.bean.Custom;
import com.cskaoyan.bean.Page;
import com.cskaoyan.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: TXJ
 * @Date: 2019/6/26 23:14
 * @Version 1.0
 */
@Controller
@RequestMapping("/custom")
public class CustomController {
    @Autowired
    CustomService customService;

    @RequestMapping("/find")
    public String find() {
        return "custom_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Page getItemList(Integer page,Integer rows,Custom custom)throws Exception{
        Page page1=customService.getList(page,rows,custom);
        return page1;
    }

    @RequestMapping("get_data")
    @ResponseBody
    public List<Custom> list() throws Exception {
        List <Custom> list=customService.find();
        return list;
    }
    
}
