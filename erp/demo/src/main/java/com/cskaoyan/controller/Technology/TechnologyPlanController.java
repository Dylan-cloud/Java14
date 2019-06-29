package com.cskaoyan.controller.Technology;

import com.cskaoyan.bean.Technology.Technology;
import com.cskaoyan.bean.Technology.TechnologyPlan;
import com.cskaoyan.bean.Technology.TechnologyPlanVo;
import com.cskaoyan.service.Impl.Technology.TechnologyPlanServiceImpl;
import com.cskaoyan.util.EUDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/technologyPlan")
public class TechnologyPlanController {

    @Autowired
    TechnologyPlanServiceImpl technologyPlanService;

    @RequestMapping(value = {"/edit_judge","/edit"})
    public String edit(){
        return "/technologyPlan_edit";
    }

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

    @RequestMapping("/update_all")
    @ResponseBody
    public Map updateAll(TechnologyPlan technologyPlan){
        technologyPlanService.updateByPrimaryKeySelective(technologyPlan);
        Map<String,Object> map=new HashMap<>();
        map.put("status",200);
        return map;
    }

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult selectAll(int page, int rows) {
        EUDataGridResult result = technologyPlanService.selectPageTechnology(page, rows);
        return result;
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<TechnologyPlan> getData(){
        List<TechnologyPlan> list=technologyPlanService.selectAll();
        return list;
    }

    @RequestMapping("/find")
    public String findTechnologyPlan(){
        return "technologyPlan_list";
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public TechnologyPlanVo getTechnologyById(@PathVariable String id){
        TechnologyPlanVo technologyPlanVo = technologyPlanService.selectTechnologyPlanVo(id);
        return technologyPlanVo;
    }

    @RequestMapping("/search_technologyPlan_by_technologyName")
    @ResponseBody
    public Map selectTechnologyPlanVoByName(String searchValue){
        Map<String,Object> map = new HashMap<>();
        List<TechnologyPlanVo> list = technologyPlanService.selectTPVByTechnologyName(searchValue);
        Integer total=list.size();
        map.put("total",total);
        map.put("rows",list);
        return map;
    }

    @RequestMapping("/search_technologyPlan_by_technologyPlanId")
    @ResponseBody
    public Map selectTechnologyPlanVoById(String searchValue){
        //根据id获取工艺对象
        TechnologyPlanVo technologyPlanVo = technologyPlanService.selectTPVByPrimaryKey(searchValue);
        //添加到list
        List<TechnologyPlanVo> list=new ArrayList<>();
        list.add(technologyPlanVo);
        //添加到map
        Integer total=list.size();
        Map<String,Object> map=new HashMap<>();
        map.put("total",total);
        map.put("rows",list);
        return map;
    }

}
