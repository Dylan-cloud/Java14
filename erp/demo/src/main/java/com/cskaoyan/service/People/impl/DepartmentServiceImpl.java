package com.cskaoyan.service.People.impl;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.People.Department;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.exception.DepartmentException;
import com.cskaoyan.mapper.People.DepartmentMapper;
import com.cskaoyan.service.People.DepartmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;


    @Override
    public List<Department> findAllDepartment(int page,int rows) {
        int total = departmentMapper.findTotal();
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;
        return departmentMapper.findAllDepartment(rows,offset);
    }

    @Override
    public int findTotal() {
        return departmentMapper.findTotal();
    }

    @Override
    public QueryStatus insertDepartment(Department department) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            int ret = departmentMapper.insertDepartment(department);
            if(ret == 1) {
                queryStatus.setStatus(200);
                queryStatus.setMsg("OK");
            }
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("该产品编号已经存在，请更换客户编号！");
        }
        return queryStatus;
    }

    @Override
    public List<Department> getDepartmentData() {
        return departmentMapper.getDepartmentData();
    }

    @Override
    public QueryStatus departmentUpdateAll(Department department) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            int ret = departmentMapper.departmentUpdateAll(department);
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
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public QueryStatus departmentDeleteBatch(String[] ids) throws DepartmentException {
        QueryStatus queryStatus = new QueryStatus();
        try {
            for (String id : ids) {
                departmentMapper.departmentDeleteBatch(id);
            }
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("删除出现故障，请重新尝试");
            throw new DepartmentException("删除出现故障，请重新尝试");
        }
        return queryStatus;
    }


    @Override
    public List<Department> searchDepartmentById(String id) {
        return departmentMapper.searchDepartmentById(id);
    }

    @Override
    public Page searchDepartmentByDepartmentId(int page, int rows, String searchValue) {
        PageHelper.startPage(page,rows);
        List<Department> list= departmentMapper.searchDepartmentByDepartmentId(searchValue);
        Page page1=new Page();
        page1.setRows(list);
        PageInfo<Department> pageInfo=new PageInfo<>(list);
        page1.setTotal(pageInfo.getTotal());
        return page1;
    }

    @Override
    public Page searchDepartmentByDepartmentName(int page, int rows, String searchValue) {
        PageHelper.startPage(page,rows);
        List<Department> list= departmentMapper.searchDepartmentByDepartmentName(searchValue);
        Page page1=new Page();
        page1.setRows(list);
        PageInfo<Department> pageInfo=new PageInfo<>(list);
        page1.setTotal(pageInfo.getTotal());
        return page1;
    }


}
