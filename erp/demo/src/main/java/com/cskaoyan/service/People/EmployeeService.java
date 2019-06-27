package com.cskaoyan.service.People;

import com.cskaoyan.bean.People.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAllEmployee(Integer page, Integer rows);

    boolean deleteBatchEmployeeByIds(String[] ids);

    boolean updateEmployeeById(Employee employee);

    boolean insertEmployee(Employee employee);

}
