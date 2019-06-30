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
    sysPermissionList.add("product:add");
    sysPermissionList.add("product:edit");
    sysPermissionList.add("product:delete");
    sysPermissionList.add("order:add");
    sysPermissionList.add("order:edit");
    sysPermissionList.add("order:delete");
    sysPermissionList.add("work:add");
    sysPermissionList.add("work:edit");
    sysPermissionList.add("work:delete");
    sysPermissionList.add("manufacture:add");
    sysPermissionList.add("manufacture:edit");
    sysPermissionList.add("manufacture:delete");
    sysPermissionList.add("task:add");
    sysPermissionList.add("task:edit");
    sysPermissionList.add("task:delete");
    sysPermissionList.add("technology:add");
    sysPermissionList.add("technology:edit");
    sysPermissionList.add("technology:delete");
    sysPermissionList.add("technologyPlan:add");
    sysPermissionList.add("technologyPlan:edit");
    sysPermissionList.add("technologyPlan:delete");
    sysPermissionList.add("technologyRequirement:add");
    sysPermissionList.add("technologyRequirement:edit");
    sysPermissionList.add("technologyRequirement:delete");
    sysPermissionList.add("process:add");
    sysPermissionList.add("process:edit");
    sysPermissionList.add("process:delete");
    request.getSession().setAttribute("sysPermissionList",sysPermissionList);
    return "home";
}


}
