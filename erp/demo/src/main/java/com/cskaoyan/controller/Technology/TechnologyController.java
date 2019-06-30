package com.cskaoyan.controller.Technology;

import com.cskaoyan.bean.Technology.Technology;
import com.cskaoyan.service.impl.Technology.TechnologyServiceImpl;
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
@RequestMapping("/technology")
public class TechnologyController {

    @Autowired
    TechnologyServiceImpl technologyService;

    @RequestMapping(value = {"/add","/add_judge"})
    public String addJudge(){
        return "technology_add";
    }

    @RequestMapping(value = {"/edit_judge","/edit"})
    public String edit(){
        return "technology_edit";
    }

    @RequestMapping("/find")
    public String findTechnology(){
        return "technology_list";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Map technologyAddForm(Technology technology){
        Map<String,Object> map = new HashMap<>();
        int insert = technologyService.insert(technology);
        map.put("status",200);
        return map;
    }

    @RequestMapping("/delete_judge")
    public String delete(){
        return "technology_list";
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map delete_batch(String[] ids){
        int b = 0;
        for (String id:ids){
            b = technologyService.deleteByPrimaryKey(id);
        }
        Map<String, Object> map = new HashMap<>();
        if (b != 0) {
            map.put("status",200);
        }
        return map;
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public Map editTechnology(Technology technology){
        technologyService.updateByPrimaryKeySelective(technology);
        Map<String,Object> map=new HashMap<>();
        map.put("status",200);
        return map;
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<Technology> getTechnology(){
        return technologyService.selectAll();
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public Technology getTechnologyById(@PathVariable String id){
        System.out.println(id);
        Technology technology=technologyService.selectByPrimaryKey(id);
        return technology;
    }

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult selectAll(int page, int rows) {
        EUDataGridResult result = technologyService.selectPageTechnology(page, rows);
        return result;
    }

    @RequestMapping("/search_technology_by_technologyId")
    @ResponseBody
    public Map selectTechnologyById(String searchValue){
        //根据id获取工艺对象
        Technology technology=technologyService.selectByPrimaryKey(searchValue);
        //添加到list
        List<Technology> list=new ArrayList<>();
        list.add(technology);
        //添加到map
        Integer total=list.size();
        Map<String,Object> map=new HashMap<>();
        map.put("total",total);
        map.put("rows",list);
        return map;
    }

    @RequestMapping("/search_technology_by_technologyName")
    @ResponseBody
    public Map selectTechnologyByName(String searchValue){
        List<Technology> list=technologyService.selectByTechnologyName(searchValue);
        Map<String,Object> map=new HashMap<>();
        Integer total=list.size();
        map.put("total",total);
        map.put("rows",list);
        return map;
    }

}
