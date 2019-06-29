package com.cskaoyan.service.plan.impl;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.VO.WorkVO;
import com.cskaoyan.bean.plan.Work;
import com.cskaoyan.mapper.plan.WorkMapper;
import com.cskaoyan.service.plan.WorkService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: TXJ
 * @Date: 2019/6/28 21:18
 * @Version 1.0
 */
@Service
public class WorkServiceImpl implements WorkService {
    @Autowired
    WorkMapper workMapper;

    @Override
    public Page findAllWork(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<WorkVO> list = workMapper.findAllWork();
        Page page1 = new Page();
        page1.setRows(list);
        PageInfo<WorkVO> pageInfo = new PageInfo<>(list);
        page1.setTotal(pageInfo.getTotal());
        return page1;
    }

    @Override
    public List<WorkVO> find() {
        return workMapper.findAllWork();
    }

    @Override
    public WorkVO get(String workId) {
        return workMapper.selectByPrimaryKey(workId);
    }

    @Override
    public QueryStatus insert(Work work) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            int ret = workMapper.insert(work);
            if (ret == 1) {
                queryStatus.setStatus(200);
                queryStatus.setMsg("ok");
            }
        } catch (Exception e) {
            queryStatus.setStatus(0);
            queryStatus.setMsg("新增作业失败，请重试");
        }
        return queryStatus;
    }

    @Override
    public QueryStatus update(Work work) {
        QueryStatus queryStatus=new QueryStatus();
        try {
            int ret=workMapper.updateByPrimaryKeySelective(work);
            if (ret==1){
                queryStatus.setStatus(200);
                queryStatus.setMsg("ok");
            }
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("修改作业失败，请重试");
        }
        return queryStatus;
    }

    @Override
    public QueryStatus delete(String id) {
        QueryStatus queryStatus = new QueryStatus();

        int ret = workMapper.deleteByPrimaryKey(id);
        if (ret == 1) {
            queryStatus.setStatus(200);
            queryStatus.setMsg("ok");
        }
        return queryStatus;
    }

    @Override
    public QueryStatus deleteBatchwork(String[] ids) {
        QueryStatus queryStatus = new QueryStatus();
        for (String id:ids){
            workMapper.deleteByPrimaryKey(id);
        }
        queryStatus.setStatus(200);
        queryStatus.setMsg("ok");
        return queryStatus;
    }

    @Override
    public Page searchWorkByWorkId(Integer page, Integer rows, String searchValue) {
        PageHelper.startPage(page, rows);
        List<WorkVO> list = workMapper.searchWorkByWorkId(searchValue);
        Page page1 = new Page();
        page1.setRows(list);
        PageInfo<WorkVO> pageInfo = new PageInfo<>(list);
        page1.setTotal(pageInfo.getTotal());
        return page1;
    }

    @Override
    public Page searchWorkByWorkProduct(Integer page, Integer rows, String searchValue) {
        PageHelper.startPage(page, rows);
        List<WorkVO> list = workMapper.searchWorkByWorkProduct(searchValue);
        Page page1 = new Page();
        page1.setRows(list);
        PageInfo<WorkVO> pageInfo = new PageInfo<>(list);
        page1.setTotal(pageInfo.getTotal());
        return page1;
    }

    @Override
    public Page searchWorkByWorkDevice(Integer page, Integer rows, String searchValue) {
        PageHelper.startPage(page, rows);
        List<WorkVO> list = workMapper.searchWorkByWorkDevice(searchValue);
        Page page1 = new Page();
        page1.setRows(list);
        PageInfo<WorkVO> pageInfo = new PageInfo<>(list);
        page1.setTotal(pageInfo.getTotal());
        return page1;
    }

    @Override
    public Page searchWorkByWorkProcess(Integer page, Integer rows, String searchValue) {
        PageHelper.startPage(page, rows);
        List<WorkVO> list = workMapper.searchWorkByWorkProcess(searchValue);
        Page page1 = new Page();
        page1.setRows(list);
        PageInfo<WorkVO> pageInfo = new PageInfo<>(list);
        page1.setTotal(pageInfo.getTotal());
        return page1;
    }
}
