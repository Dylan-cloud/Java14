package com.cskaoyan.controller.Technology;

import com.cskaoyan.bean.Technology.TechnologyRequirement;
import com.cskaoyan.service.Impl.Technology.TechnologyRequirementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("TechnologyRequirement")
public class TechnologyRequirementController {

    @Autowired
    TechnologyRequirementServiceImpl technologyRequirementService;

    /**
     * 增加单个
     * @param technologyRequirement
     */
    @RequestMapping(value = {"add","insert"})
    public void technologyRequirementAddForm(TechnologyRequirement technologyRequirement){
        int insert = technologyRequirementService.insert(technologyRequirement);
        System.out.println(insert);
    }

    /**
     * 编辑单个
     * @param technologyRequirement
     */
    @RequestMapping(value = {"edit","edit_judge","update_requirement"})
    public void technologyRequirementEditForm(TechnologyRequirement technologyRequirement){
        int insert = technologyRequirementService.insert(technologyRequirement);
        System.out.println(insert);
    }

    /**
     * 查询所有
     * @return
     */
    @RequestMapping("list")
    public List<TechnologyRequirement> selectAll(){
        List<TechnologyRequirement> technologyRequirements = technologyRequirementService.selectAll();
        return technologyRequirements;
    }

    /**
     * 根据主键删除单个
     * @param technologyRequirementId
     */
    @RequestMapping("delete_judge")
    public void deleteByPrimaryKey(String technologyRequirementId){
        int i = technologyRequirementService.deleteByPrimaryKey(technologyRequirementId);
        System.out.println("i = " + i);
    }


}
