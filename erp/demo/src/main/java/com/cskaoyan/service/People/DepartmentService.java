package com.cskaoyan.service.People;

import com.cskaoyan.bean.People.Department;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.exception.DepartmentException;

import java.util.List;

public interface DepartmentService {

    List<Department> findAllDepartment(int page, int rows);

    int findTotal();

    QueryStatus insertDepartment(Department department);

    List<Department> getDepartmentData();

    QueryStatus departmentUpdateAll(Department department);

    QueryStatus departmentDeleteBatch(String[] ids) throws DepartmentException;

    List<Department> searchDepartmentById(String id);
}
