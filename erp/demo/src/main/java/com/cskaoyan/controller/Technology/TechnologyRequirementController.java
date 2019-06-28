package com.cskaoyan.controller.Technology;

import com.cskaoyan.bean.Technology.Technology;
import com.cskaoyan.bean.Technology.TechnologyRequirement;
import com.cskaoyan.service.Impl.Technology.TechnologyRequirementServiceImpl;
import com.cskaoyan.util.EUDataGridResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/technologyRequirement")
public class TechnologyRequirementController {

    @Autowired
    TechnologyRequirementServiceImpl technologyRequirementService;

    @RequestMapping(value = {"/add","add_judge"})
    public String addJudge(){
        return "technologyRequirement_add";
    }

    @RequestMapping("/delete_judge")
    public String deleteJudge(){
        return "technologyRequirement_list";
    }

    @RequestMapping("/delete_batch")
    public Map deleteBatch(String[] ids){
        for (String id : ids) {
            int i = technologyRequirementService.deleteByPrimaryKey(id);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("status",200);
        return map;
    }

    @RequestMapping("/edit")
    public String edit(){
        return "technologyRequirement_edit";
    }

    @RequestMapping("/edit_judge")
    public String editJudge(){
        return "technologyRequirement_list";
    }

/*    @RequestMapping("/get_data")
    public List<TechnologyRequirement> getData(){
        return technologyRequirementService.selectAll();
    }*/

    @RequestMapping("/insert")
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

}
