package com.cskaoyan.service.impl.People;

import com.cskaoyan.bean.People.Employee;
import com.cskaoyan.mapper.People.EmployeeMapper;
import com.cskaoyan.service.People.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;


    @Override
    public List<Employee> findAllEmployee(Integer page, Integer rows) {
        List<Employee> employeeList = employeeMapper.findAllEmployee((page-1)*rows,rows);
        return employeeList;
    }

    @Override
    public boolean deleteBatchEmployeeByIds(String[] ids) {
        int i = employeeMapper.deleteBatchEmployeeByIds(ids);
        return i==ids.length;
    }

    @Override
    public boolean updateEmployeeById(Employee employee) {
        int update = employeeMapper.updateByPrimaryKey(employee);
        return update==1;
    }

    @Override
    public boolean insertEmployee(Employee employee) {
        int i = employeeMapper.insert(employee);
        return i==1;
    }
}
