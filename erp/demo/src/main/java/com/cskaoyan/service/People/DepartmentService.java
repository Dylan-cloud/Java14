package com.cskaoyan.service.People;

import com.cskaoyan.bean.People.Department;

import java.util.List;

public interface DepartmentService {

    boolean deleteBatchDepartmentByIds(String[] ids);

    List<Department> findAllDepartment(Integer page, Integer rows);

    boolean updateDepartmentById(Department department);

    boolean insertDepartment(Department department);
}
