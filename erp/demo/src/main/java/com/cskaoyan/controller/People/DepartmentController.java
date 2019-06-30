package com.cskaoyan.controller.People;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.People.Department;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.exception.DepartmentException;
import com.cskaoyan.service.People.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    Page resultVo = new Page();

    @RequestMapping("/department/find")
    public String findDepartment(){return "department_list"; }


    @RequestMapping("/department/list")
    @ResponseBody
    public Page findAllDepartment(int page, int rows){


        List<Department> departmentList = departmentService.findAllDepartment(page,rows);
        int total = departmentService.findTotal();
        resultVo.setRows(departmentList);
        resultVo.setTotal(total);
        return resultVo;
    }

    @RequestMapping("/department/add_judge")
    public String addDepartment(){

        return "department_add";
    }
    @RequestMapping("/department/add")
    public String departmentAdd(){

        return "department_add";
    }

    @RequestMapping("department/insert")
    @ResponseBody
    public QueryStatus departmentInsert(Department department){
        return departmentService.insertDepartment(department);
    }

    @RequestMapping("/department/get_data")
    @ResponseBody
    public List<Department> getDepartmentData(){
        return departmentService.getDepartmentData();
    }

    @RequestMapping("/department/edit_judge")
    public String departmentEditJudge(){
        return "department_edit";
    }

    @RequestMapping("/department/edit")
    public String departmentEdit(){
        return "department_edit";
    }


    @RequestMapping("department/update_all")
    @ResponseBody
    public QueryStatus departmentUpdateAll(Department department){
        return departmentService.departmentUpdateAll(department);
    }

    @RequestMapping("department/delete_judge")
    @ResponseBody
    public QueryStatus departmentDeleteJudge(){
        return new QueryStatus();
    }

    @RequestMapping("department/delete_batch")
    @ResponseBody
    public QueryStatus deleteBatch(String[] ids){
        try {
            return departmentService.departmentDeleteBatch(ids);
        } catch (DepartmentException e) {
            QueryStatus queryStatus = new QueryStatus();
            queryStatus.setStatus(0);
            queryStatus.setMsg(e.getMessage());
            return queryStatus;
        }
    }

    @RequestMapping("department/search_department_by_departmentId")
    @ResponseBody
    public Page searchDepartmentById(String id){
        Page resultVo = new Page();
        List<Department> departmentById = departmentService.searchDepartmentById(id);
        resultVo.setTotal(1);
        resultVo.setRows(departmentById);
        return resultVo;
    }
}
