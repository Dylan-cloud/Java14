package com.cskaoyan.service.People.impl;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.People.Department;
import com.cskaoyan.bean.People.Employee;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.exception.EmployeeException;
import com.cskaoyan.mapper.People.EmployeeMapper;
import com.cskaoyan.service.People.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    @Override
    public Employee[] getEmployees() {
        Employee[] employees = employeeMapper.getEmployees();
        return employees;
    }

    @Override
    public Employee selectEmployeeById(String deviceKeeperId) {
        Employee employee = employeeMapper.selectEmployeeById(deviceKeeperId);
        return employee;
    }

    @Override

    public Page findAllEmployees(int page, int rows) {
        Page resultVo = new Page();
        int total = employeeMapper.findEmployeeTotal();
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;
        List<Employee> employeeList = employeeMapper.findAllEmployees(rows, offset);
        resultVo.setRows(employeeList);
        resultVo.setTotal(total);
        return resultVo;
    }

    @Override
    public Department getDepartmentData(String id) {
        return employeeMapper.getDepartmentData(id);
    }

    @Override
    public QueryStatus employeeUpdateAll(Employee employee) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            int ret = employeeMapper.employeeUpdateAll(employee);
            if(ret == 1){
                queryStatus.setStatus(200);
                queryStatus.setMsg("OK");
            }
        } catch (Exception e) {
            queryStatus.setStatus(0);
            queryStatus.setMsg("修改失败，请重新尝试！");
        }
        return queryStatus;
    }

    @Override
    public QueryStatus insertEmployee(Employee employee) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            int ret = employeeMapper.insertEmployee(employee);
            if(ret == 1) {
                queryStatus.setStatus(200);
                queryStatus.setMsg("OK");
            }
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("该员工编号已经存在，请更换客户编号！");
        }
        return queryStatus;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public QueryStatus employeeDeleteBatch(String[] ids) throws EmployeeException {
        QueryStatus queryStatus = new QueryStatus();
        try {
            for (String id : ids) {
                employeeMapper.employeeDeleteBatch(id);
            }

            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("删除出现故障，请重新尝试");
            throw new EmployeeException("删除出现故障，请重新尝试");
        }
        return queryStatus;


    }

}
