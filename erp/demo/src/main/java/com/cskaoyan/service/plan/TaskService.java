package com.cskaoyan.service.plan;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.plan.Task;

import java.util.List;

/**
 * @Author: TXJ
 * @Date: 2019/6/29 21:19
 * @Version 1.0
 */
public interface TaskService {
    Task get(String empId);

    Page findAllTask(Integer page, Integer rows);

    QueryStatus insert(Task work);

    QueryStatus update(Task work);

    QueryStatus delete(String id);

    QueryStatus deleteBatchwork(String[] ids);

    Page searchtaskBytaskId(Integer page, Integer rows, String searchValue);

    Page searchtaskBytaskWorkId(Integer page, Integer rows, String searchValue);

    Page searchtaskManufactureSn(Integer page, Integer rows, String searchValue);

    List<Task> find();
}
