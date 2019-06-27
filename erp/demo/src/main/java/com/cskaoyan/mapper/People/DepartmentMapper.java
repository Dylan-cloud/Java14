package com.cskaoyan.mapper.People;

import com.cskaoyan.bean.People.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(String departmentId);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(String departmentId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> findAllDepartment(@Param("offset") Integer offest, @Param("rows") Integer rows);

    int deleteBatchDepartmentByIds(@Param("ids") String[] ids);


}