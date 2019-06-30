package com.cskaoyan.controller.People;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.People.Department;
import com.cskaoyan.bean.People.Employee;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.exception.EmployeeException;
import com.cskaoyan.service.People.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("employee/get_data")
    @ResponseBody
    public Employee[] getEmployeeData(){
        return employeeService.getEmployees();
    }

    @RequestMapping("employee/find")
    public String findEmployee(){
        return "employee_list";
    }

    @RequestMapping("employee/list")
    @ResponseBody
    public Page findAllEmployees(int page, int rows){
        return employeeService.findAllEmployees(page, rows);
    }

    @RequestMapping("department/get/{id}")
    @ResponseBody
    public Department getDepartmentData(@ModelAttribute("id") String id){
        return employeeService.getDepartmentData(id);
    }

    @RequestMapping("employee/add_judge")
    public String addEmployee(){

        return "employee_add";
    }
    @RequestMapping("employee/add")
    public String employeeAdd(){

        return "employee_add";
    }

    @RequestMapping("employee/insert")
    @ResponseBody
    public QueryStatus employeeInsert(Employee employee){
        return employeeService.insertEmployee(employee);
    }

    @RequestMapping("employee/edit_judge")
    public String employeeEditJudge(){
        return "employee_edit";
    }

    @RequestMapping("employee/edit")
    public String employeeEdit(){
        return "employee_edit";
    }


    @RequestMapping("employee/update_all")
    @ResponseBody
    public QueryStatus employeeUpdateAll(Employee employee){
        return employeeService.employeeUpdateAll(employee);
    }

    @RequestMapping("employee/delete_judge")
    @ResponseBody
    public QueryStatus employeeDeleteJudge(){
        return new QueryStatus();
    }

    @RequestMapping("employee/delete_batch")
    @ResponseBody
    public QueryStatus deleteBatch(String[] ids){
        try {
            return employeeService.employeeDeleteBatch(ids);
        } catch (EmployeeException e) {
            QueryStatus queryStatus = new QueryStatus();
            queryStatus.setStatus(0);
            queryStatus.setMsg(e.getMessage());
            return queryStatus;
        }

    }

    @RequestMapping("/employee/get/{deviceKeeperId}")
    @ResponseBody
    public Employee selectEmployeeById(@PathVariable("deviceKeeperId")String deviceKeeperId){
        Employee employee = employeeService.selectEmployeeById(deviceKeeperId);
        return employee;
    }
}
