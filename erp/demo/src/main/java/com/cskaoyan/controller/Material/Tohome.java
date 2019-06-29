package com.cskaoyan.controller.Material;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Tohome {
    @RequestMapping("/")
    public ModelAndView tohome(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        List<String> sysPermissionList = new ArrayList<>();

        sysPermissionList.add("material:add");
        sysPermissionList.add("material:edit");
        sysPermissionList.add("material:delete");

        sysPermissionList.add("materialReceive:add");
        sysPermissionList.add("materialReceive:edit");
        sysPermissionList.add("materialReceive:delete");

        sysPermissionList.add("materialConsume:add");
        sysPermissionList.add("materialConsume:edit");
        sysPermissionList.add("materialConsume:delete");

        session.setAttribute("sysPermissionList", sysPermissionList);
        modelAndView.setViewName("home");
        return modelAndView;
    }
}
