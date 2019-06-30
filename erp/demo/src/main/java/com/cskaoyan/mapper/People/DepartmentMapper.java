package com.cskaoyan.mapper.People;

import com.cskaoyan.bean.People.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {

    List<Department> findAllDepartment(@Param("rows") int rows, @Param("offset") int offset);

    int findTotal();

    int insertDepartment(Department department);

    List<Department> getDepartmentData();

    int departmentUpdateAll(Department department);

    int departmentDeleteBatch(@Param("id") String departmentId);

    List<Department> searchDepartmentById(@Param("id") String departmentId);
}
