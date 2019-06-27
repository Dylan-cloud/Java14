package com.cskaoyan.controller.Technology;

import com.cskaoyan.bean.Technology.Technology;
import com.cskaoyan.service.TechnologyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TechnologyController {

    @Autowired
    TechnologyServiceImpl technologyService;

    @RequestMapping("technologyAddForm")
    public void technologyAddForm(Technology technology){
        technologyService.insert(technology);
    }

    @RequestMapping("technologyEditForm")
    public void technologyEditForm(Technology technology){
        technologyService.updateByPrimaryKey(technology);
    }

    @RequestMapping("login")
    public String login(){
        return "/WEB-INF/jsp/home.jsp";
    }


}
