package com.cskaoyan.controller.People;

import com.cskaoyan.bean.People.Department;
import com.cskaoyan.bean.Tip;
import com.cskaoyan.service.People.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;


    @RequestMapping("*_judge")
    @ResponseBody
    public String judge(){
        return "";
    }


    @RequestMapping("find")
    public String find(){
        return "department_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public List<Department> findAllManufacture(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows){
        List<Department> departmentList = departmentService.findAllDepartment(page, rows);
        return departmentList;
    }


    //批量删除
    @RequestMapping("delete_batch")
    @ResponseBody
    public Tip deletleBatchByIds(String[] ids){
        boolean b = departmentService.deleteBatchDepartmentByIds(ids);
        if(b){
            return new Tip("200","删除成功。",null);
        }
        return new Tip("0","删除失败。",null);
    }


    //修改数据
    @RequestMapping("edit")
    public String edit(){
        return "work_edit";
    }

    @RequestMapping("update_all")
    @ResponseBody
    public Tip updatedepartment(Department department){
        boolean b = departmentService.updateDepartmentById(department);
        if (b){
            return new Tip("200","修改成功。",null);
        }
        return new Tip("0","修改失败。",null);
    }

    //新增一条数据
    @RequestMapping("add")
    public String add(){
        return "department_add";
    }

    @RequestMapping("insert")
    @ResponseBody
    public Tip insert(Department department){

        boolean b = departmentService.insertDepartment(department);
        if (b){
            return new Tip("200","增加成功。",null);
        }
        return new Tip("0","添加失败。",null);
    }

}
