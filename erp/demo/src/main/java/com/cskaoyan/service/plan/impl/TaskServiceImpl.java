package com.cskaoyan.service.plan.impl;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.plan.Task;
import com.cskaoyan.mapper.plan.TaskMapper;
import com.cskaoyan.service.plan.TaskService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: TXJ
 * @Date: 2019/6/29 21:19
 * @Version 1.0
 */
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskMapper taskMapper;

    @Override
    public List<Task> find() {
        return taskMapper.find();
    }

    @Override
    public Task get(String empId) {
        return taskMapper.selectByPrimaryKey(empId);
    }

    @Override
    public Page findAllTask(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<Task> list=taskMapper.find();
        Page page1=new Page();
        PageInfo<Task> pageInfo=new PageInfo<>(list);
        page1.setTotal(pageInfo.getTotal());
        page1.setRows(list);
        return page1;
    }

    @Override
    public QueryStatus insert(Task work) {
        QueryStatus queryStatus=new QueryStatus();
        try{
            int ret=taskMapper.insert(work);
            if (ret==1){
                queryStatus.setStatus(200);
                queryStatus.setMsg("ok");
            }
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("派工id重复，请重新尝试添加！");
        }
        return queryStatus;
    }

    @Override
    public QueryStatus update(Task work) {
        QueryStatus queryStatus=new QueryStatus();
        try{
            int ret=taskMapper.updateByPrimaryKey(work);
            if (ret==1){
                queryStatus.setStatus(200);
                queryStatus.setMsg("ok");
            }
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("派工id重复，请重新尝试编辑！");
        }
        return queryStatus;
    }

    @Override
    public QueryStatus delete(String id) {
        QueryStatus queryStatus=new QueryStatus();
        try{
            int ret=taskMapper.deleteByPrimaryKey(id);
            if (ret==1){
                queryStatus.setStatus(200);
                queryStatus.setMsg("ok");
            }
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("派工id重复，请重新尝试编辑！");
        }
        return queryStatus;
    }

    @Override
    public QueryStatus deleteBatchwork(String[] ids) {
        QueryStatus queryStatus=new QueryStatus();
        for (String id:ids) {
            int ret = taskMapper.deleteByPrimaryKey(id);
        }
                queryStatus.setStatus(200);
                queryStatus.setMsg("ok");
        return queryStatus;
    }

    @Override
    public Page searchtaskBytaskId(Integer page, Integer rows, String searchValue) {
        PageHelper.startPage(page,rows);
        List<Task> list=taskMapper.searchTaskByTaskId(searchValue);
        Page page1=new Page();
        PageInfo<Task> pageInfo=new PageInfo<>(list);
        page1.setTotal(pageInfo.getTotal());
        page1.setRows(list);
        return page1;
    }

    @Override
    public Page searchtaskBytaskWorkId(Integer page, Integer rows, String searchValue) {
        PageHelper.startPage(page,rows);
        List<Task> list=taskMapper.searchTaskByTaskWorkId(searchValue);
        Page page1=new Page();
        PageInfo<Task> pageInfo=new PageInfo<>(list);
        page1.setTotal(pageInfo.getTotal());
        page1.setRows(list);
        return page1;
    }

    @Override
    public Page searchtaskManufactureSn(Integer page, Integer rows, String searchValue) {
        PageHelper.startPage(page,rows);
        List<Task> list=taskMapper.searchTaskByTaskManufactureSn(searchValue);
        Page page1=new Page();
        PageInfo<Task> pageInfo=new PageInfo<>(list);
        page1.setTotal(pageInfo.getTotal());
        page1.setRows(list);
        return page1;
    }
    }
