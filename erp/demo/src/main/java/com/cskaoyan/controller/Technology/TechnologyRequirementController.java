package com.cskaoyan.controller.Technology;

import com.cskaoyan.bean.Technology.Technology;
import com.cskaoyan.bean.Technology.TechnologyRequirement;
import com.cskaoyan.bean.Technology.TechnologyRequirementVo;
import com.cskaoyan.service.impl.Technology.TechnologyRequirementServiceImpl;
import com.cskaoyan.service.impl.Technology.TechnologyServiceImpl;
import com.cskaoyan.util.EUDataGridResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/technologyRequirement")
public class TechnologyRequirementController {

    @Autowired
    TechnologyRequirementServiceImpl technologyRequirementService;
    @Autowired
    TechnologyServiceImpl technologyService;


    @RequestMapping(value = {"/add","add_judge"})
    public String addJudge(){
        return "technologyRequirement_add";
    }

    @RequestMapping(value = {"/edit_judge","/edit"})
    public String edit(){
        return "technologyRequirement_edit";
    }

    @RequestMapping("/delete_judge")
    public String deleteJudge(){
        return "technologyRequirement_list";
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map deleteBatch(String[] ids){
        for (String id : ids) {
            int i = technologyRequirementService.deleteByPrimaryKey(id);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("status",200);
        return map;
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<Technology> getTechnology(){
        return technologyService.selectAll();
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Map insert(TechnologyRequirement technologyRequirement){
        Map<String ,Object> map = new HashMap<>();
        int insert = technologyRequirementService.insert(technologyRequirement);
        if (insert == 1){
            map.put("status",200);
        }
        return map;
    }

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult selectAll(int page, int rows) {
        EUDataGridResult result = technologyRequirementService.selectPageTechnology(page, rows);
        return result;
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public Map updateAll(TechnologyRequirement requirement,Integer page,Integer rows){
        Map<String,Object> map=new HashMap<>();
        int flag=technologyRequirementService.updateByPrimaryKey(requirement);
        if (flag != 0){
            map.put("status",200);
        }
        return map;
    }

    @RequestMapping("/find")
    public String findTechnologyRequirement(){
        return "technologyRequirement_list";
    }

    @RequestMapping("/search_technologyRequirement_by_technologyRequirementId")
    @ResponseBody
    public Map selectTRVById(String searchValue){
        //根据id获取工艺对象
        TechnologyRequirementVo technologyRequirementVo = technologyRequirementService.selectTRVByPrimaryKey(searchValue);
        List<TechnologyRequirementVo> list=new ArrayList<>();
        list.add(technologyRequirementVo);
        Integer total=list.size();
        Map<String,Object> map=new HashMap<>();
        map.put("total",total);
        map.put("rows",list);
        return map;
    }

    @RequestMapping("/search_technologyRequirement_by_technologyName")
    @ResponseBody
    public Map selectTechnologyRequirementByName(String searchValue){
        List<TechnologyRequirementVo> list = technologyRequirementService.selectTRVByTechnologyName(searchValue);
        Map<String,Object> map=new HashMap<>();
        Integer total=list.size();
        map.put("total",total);
        map.put("rows",list);
        return map;
    }

}
