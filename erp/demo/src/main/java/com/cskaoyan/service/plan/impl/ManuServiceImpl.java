package com.cskaoyan.service.plan.impl;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.VO.ManufactureVO;
import com.cskaoyan.bean.plan.Manufacture;
import com.cskaoyan.mapper.plan.ManufactureMapper;
import com.cskaoyan.service.plan.ManuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: TXJ
 * @Date: 2019/6/29 19:43
 * @Version 1.0
 */
@Service
public class ManuServiceImpl implements ManuService {
    @Autowired
    ManufactureMapper manufactureMapper;

    @Override
    public ManufactureVO get(String manuId) {
        return manufactureMapper.selectByPrimaryKey(manuId);
    }

    @Override
    public List<ManufactureVO> find() {
        return manufactureMapper.find();
    }

    @Override
    public Page findAllManu(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<ManufactureVO> list = manufactureMapper.find();
        Page page1 = new Page();
        PageInfo<ManufactureVO> pageInfo = new PageInfo<>(list);
        page1.setTotal(pageInfo.getTotal());
        page1.setRows(list);
        return page1;
    }

    @Override
    public QueryStatus insert(Manufacture work) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            int ret = manufactureMapper.insert(work);
            if (ret == 1) {
                queryStatus.setStatus(200);
                queryStatus.setMsg("ok");
            }
        } catch (Exception e) {
            queryStatus.setStatus(0);
            queryStatus.setMsg("任务ID已存在，请重试！");
        }
        return queryStatus;
    }

    @Override
    public QueryStatus update(Manufacture work) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            int ret = manufactureMapper.updateByPrimaryKey(work);
            if (ret == 1) {
                queryStatus.setStatus(200);
                queryStatus.setMsg("ok");
            }
        } catch (Exception e) {
            queryStatus.setStatus(0);
            queryStatus.setMsg("任务ID已存在，请重试！");
        }
        return queryStatus;
    }

    @Override
    public QueryStatus delete(String id) {
        QueryStatus queryStatus = new QueryStatus();
        int ret = manufactureMapper.deleteByPrimaryKey(id);
        if (ret == 1) {
            queryStatus.setStatus(200);
            queryStatus.setMsg("ok");
        }
        return queryStatus;
    }

    @Override
    public QueryStatus deleteBatchwork(String[] ids) {
        QueryStatus queryStatus = new QueryStatus();
        for (String id : ids) {
            manufactureMapper.deleteByPrimaryKey(id);
        }

        queryStatus.setStatus(200);
        queryStatus.setMsg("ok");

        return queryStatus;
    }

    @Override
    public Page searchManufactureByManufactureSn(Integer page, Integer rows, String searchValue) {
        PageHelper.startPage(page, rows);
        List<ManufactureVO> list = manufactureMapper.searchManufactureByManufactureSn(searchValue);
        Page page1 = new Page();
        PageInfo<ManufactureVO> pageInfo = new PageInfo<>(list);
        page1.setTotal(pageInfo.getTotal());
        page1.setRows(list);
        return page1;
    }

    @Override
    public Page searchManufactureBymanufactureOrderId(Integer page, Integer rows, String searchValue) {
        PageHelper.startPage(page, rows);
        List<ManufactureVO> list = manufactureMapper.searchManufactureByManufactureOrderId(searchValue);
        Page page1 = new Page();
        PageInfo<ManufactureVO> pageInfo = new PageInfo<>(list);
        page1.setTotal(pageInfo.getTotal());
        page1.setRows(list);
        return page1;
    }

    @Override
    public Page searchManufactureBymanufactureTechnologyName(Integer page, Integer rows, String searchValue) {
        PageHelper.startPage(page, rows);
        List<ManufactureVO> list = manufactureMapper.searchManufactureByManufactureTechnologyName(searchValue);
        Page page1 = new Page();
        PageInfo<ManufactureVO> pageInfo = new PageInfo<>(list);
        page1.setTotal(pageInfo.getTotal());
        page1.setRows(list);
        return page1;
    }
}

