package com.cskaoyan.controller.People;

import com.cskaoyan.bean.People.Employee;
import com.cskaoyan.bean.Tip;
import com.cskaoyan.service.People.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

  /*  @RequestMapping("get_data")
    @ResponseBody
    public List<Employee> getData(){
        List<Employee> allEmployee = employeeService.findAllEmployee();
        return allEmployee;
    }*/

    @RequestMapping("*_judge")
    @ResponseBody
    public String judge(){
        return "";
    }


    @RequestMapping("find")
    public String find(){
        return "employee_list";
    }


    @RequestMapping("list")
    @ResponseBody
    public List<Employee> findAllManufacture(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows){
        List<Employee> employeeList = employeeService.findAllEmployee(page, rows);
        return employeeList;
    }


    //批量删除
    @RequestMapping("delete_batch")
    @ResponseBody
    public Tip deletleBatchByIds(String[] ids){
        boolean b = employeeService.deleteBatchEmployeeByIds(ids);
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
    public Tip updateEmployee(Employee employee){
        boolean b = employeeService.updateEmployeeById(employee);
        if (b){
            return new Tip("200","修改成功。",null);
        }
        return new Tip("0","修改失败。",null);
    }

    //新增一条数据
    @RequestMapping("add")
    public String add(){
        return "employee_add";
    }

    @RequestMapping("insert")
    @ResponseBody
    public Tip insert(Employee employee){

        boolean b = employeeService.insertEmployee(employee);
        if (b){
            return new Tip("200","增加成功。",null);
        }
        return new Tip("0","添加失败。",null);
    }

}
