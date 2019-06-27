package com.cskaoyan.controller.Technology;

import com.cskaoyan.bean.Technology.TechnologyPlan;
import com.cskaoyan.service.Impl.Technology.TechnologyPlanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/TechnologyPlan")
public class TechnologyPlanController {

    @Autowired
    TechnologyPlanServiceImpl technologyPlanService;

    /**
     * 增加单个TechnologyPlan
     * @param technologyPlan
     */
    @RequestMapping("/insert")
    @ResponseBody
    public Map insert(TechnologyPlan technologyPlan){
        Map<String,Object> map = new HashMap<>();
        int insert = technologyPlanService.insert(technologyPlan);
        map.put("status",200);
        return map;
    }

    @RequestMapping(value = {"/add","/add_judge"})
    public String addJudge(){
        return "technologyPlan_add";
    }

    @RequestMapping("/delete_judge")
    public String deleteJudge(){
        return "technologyPlan_list";
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map deleteBatch(String[] ids){
        int b = 0;
        for (String id:ids){
            b = technologyPlanService.deleteByPrimaryKey(id);
        }
        Map<String, Object> map = new HashMap<>();
        if (b != 0) {
            map.put("status",200);
        }
        return map;
    }

    @RequestMapping("/edit")
    public String edit(){
        return "/technologyPlan_edit";
    }
    @RequestMapping("/edit_judge")
    public String editJudge(){
        return "/technologyPlan_list";
    }

    @RequestMapping("/search_technologyPlan_by_technologyPlanName")
    public Map selectTechnologyPlanByName(String searchValue){
        Map<String,Object> map = new HashMap<>();
        List<TechnologyPlan> list = technologyPlanService.selectByName(searchValue);

        Integer total=list.size();
        map.put("total",total);
        map.put("rows",list);
        return map;
    }

    @RequestMapping("/update_all")
    public Map updateAll(TechnologyPlan technologyPlan){
        technologyPlanService.updateByPrimaryKeySelective(technologyPlan);
        Map<String,Object> map=new HashMap<>();
        map.put("status",200);
        return map;
    }
}
