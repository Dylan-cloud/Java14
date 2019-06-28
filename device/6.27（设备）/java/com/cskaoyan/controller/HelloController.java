package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    @RequestMapping("/home")
    public String home(HttpServletRequest request)
    {
        List<String> sysPermissionList=new ArrayList<String>();
        sysPermissionList.add("device:add");
        sysPermissionList.add("device:edit");
        sysPermissionList.add("device:delete");
        sysPermissionList.add("deviceType:add");
        sysPermissionList.add("deviceType:edit");
        sysPermissionList.add("deviceType:delete");
        request.getSession().setAttribute("sysPermissionList",sysPermissionList);
        return "home";
    }
}
