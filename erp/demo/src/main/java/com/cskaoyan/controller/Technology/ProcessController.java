package com.cskaoyan.controller.Technology;

import com.cskaoyan.bean.Technology.Process;
import com.cskaoyan.bean.Technology.TechnologyPlanVo;
import com.cskaoyan.service.impl.Technology.ProcessServiceImpl;
import com.cskaoyan.service.impl.Technology.TechnologyPlanServiceImpl;
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
@RequestMapping("/process")
public class ProcessController {

    @Autowired
    ProcessServiceImpl processService;
    @Autowired
    TechnologyPlanServiceImpl technologyPlanService;

    @RequestMapping(value = {"/edit_judge","/edit"})
    public String edit_judge(){
        return "process_edit";
    }

    @RequestMapping(value = {"/add","/add_judge"})
    public String addJudge(){
        return "process_add";
    }

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult selectAll(int page, int rows) {
        EUDataGridResult result = processService.selectPageTechnology(page, rows);
        return result;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Map insert(Process process){
        Map<String,Object> map=new HashMap<>();
        int b=processService.insert(process);
        if (b != 0){
            map.put("status",200);
        }
        return map;
    }

    @RequestMapping(value = {"/delete_judge","/find"})
    public String delete(){
        return "process_list";
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map delete_batch(String[] ids){
        int b = 0;
        for (String id:ids){
            b = processService.deleteByPrimaryKey(id);
        }
        Map<String, Object> map = new HashMap<>();
        if (b != 0) {
            map.put("status",200);
        }
        return map;
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public Map updateAll(Process process){
        int i = processService.updateByPrimaryKey(process);
        Map<String ,Object> map = new HashMap<>();
        map.put("status",200);
        return map;
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public TechnologyPlanVo getTechnologyById(@PathVariable String technologyPlanId){
        TechnologyPlanVo technologyPlanVo = technologyPlanService.selectTechnologyPlanVo(technologyPlanId);
        return technologyPlanVo;
    }

    @RequestMapping("/search_process_by_processId")
    @ResponseBody
    public Map selectProcessById(String searchValue){
        Map<String,Object> map = new HashMap<>();
        Process process = processService.selectProcessById(searchValue);
        List<Process> list = new ArrayList<>();
        list.add(process);
        Integer total=list.size();
        map.put("total",total);
        map.put("rows",list);
        return map;
    }

    @RequestMapping("/search_process_by_technologyPlanId")
    @ResponseBody
    public Map selectProcessByTechnologyId(String searchValue){
        Map<String,Object> map = new HashMap<>();
        List<Process> list = processService.selectProcessByTechnologyId(searchValue);
        Integer total=list.size();
        map.put("total",total);
        map.put("rows",list);
        return map;
    }
}
