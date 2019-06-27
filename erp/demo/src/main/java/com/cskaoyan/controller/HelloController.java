package com.cskaoyan.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: TXJ
 * @Date: 2019/6/26 21:58
 * @Version 1.0
 */
@Controller
public class HelloController {

@RequestMapping("hello")
    public String hello(HttpServletRequest request){
    List<String> sysPermissionList=new ArrayList<>();
    sysPermissionList.add("custom:add");
    sysPermissionList.add("custom:edit");
    sysPermissionList.add("custom:delete");
    request.getSession().setAttribute("sysPermissionList",sysPermissionList);
    return "home";
}


}
