package com.cskaoyan.mapper.plan;

import com.cskaoyan.bean.plan.Task;

import java.util.List;

public interface TaskMapper {
    int deleteByPrimaryKey(String taskId);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(String taskId);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);
    List<Task> find();

    List<Task> searchTaskByTaskId(String taskId);

    List<Task> searchTaskByTaskWorkId(String taskWorkId);

    List<Task> searchTaskByTaskManufactureSn(String taskManufactureSn);
}