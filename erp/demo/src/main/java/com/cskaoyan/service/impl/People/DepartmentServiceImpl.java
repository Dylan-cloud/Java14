package com.cskaoyan.service.impl.People;

import com.cskaoyan.bean.People.Department;
import com.cskaoyan.mapper.People.DepartmentMapper;
import com.cskaoyan.service.People.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;


    @Override
    public boolean deleteBatchDepartmentByIds(String[] ids) {
        int i = departmentMapper.deleteBatchDepartmentByIds(ids);
        return i==ids.length;
    }

    @Override
    public List<Department> findAllDepartment(Integer page, Integer rows) {
        List<Department> departmentList = departmentMapper.findAllDepartment((page-1)*rows,rows);
        return departmentList;
    }

    @Override
    public boolean updateDepartmentById(Department department) {
        int update = departmentMapper.updateByPrimaryKey(department);
        return update==1;
    }

    @Override
    public boolean insertDepartment(Department department) {
        int i = departmentMapper.insert(department);
        return i==1;
    }
}
