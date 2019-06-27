package com.cskaoyan.controller.Technology;

import com.cskaoyan.bean.Technology.TechnologyPlan;
import com.cskaoyan.service.TechnologyPlanServiceImpl;
import com.cskaoyan.service.TechnologyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TechnologyPlanController {

    @Autowired
    TechnologyPlanServiceImpl technologyPlanService;

    @RequestMapping("technologyPlanAddForm")
    public void technologyPlanAddForm(TechnologyPlan technologyPlan){
        int insert = technologyPlanService.insert(technologyPlan);

    }

}
