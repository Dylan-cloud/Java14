package com.cskaoyan.service.plan;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.VO.WorkVO;
import com.cskaoyan.bean.plan.Work;

import java.util.List;

/**
 * @Author: TXJ
 * @Date: 2019/6/28 21:18
 * @Version 1.0
 */
public interface WorkService {

    Page findAllWork(int page, int rows);

    List<WorkVO> find();

    WorkVO get(String workId);

    QueryStatus insert(Work work);

    QueryStatus update(Work work);

    QueryStatus delete(String id);

    QueryStatus deleteBatchwork(String[] ids);

    Page searchWorkByWorkId(Integer page, Integer rows, String searchValue);

    Page searchWorkByWorkProduct(Integer page, Integer rows, String searchValue);

    Page searchWorkByWorkDevice(Integer page, Integer rows, String searchValue);

    Page searchWorkByWorkProcess(Integer page, Integer rows, String searchValue);
}
