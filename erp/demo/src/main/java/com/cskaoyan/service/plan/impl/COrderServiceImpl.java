package com.cskaoyan.service.plan.impl;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.VO.COrderVO;
import com.cskaoyan.bean.plan.COrder;
import com.cskaoyan.mapper.plan.COrderMapper;
import com.cskaoyan.service.plan.COrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: TXJ
 * @Date: 2019/6/28 16:33
 * @Version 1.0
 */
@Service
public class COrderServiceImpl implements COrderService {
    @Autowired
    COrderMapper cOrderMapper;
    @Override
    public Page findOrder(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<COrderVO> list= cOrderMapper.find();
        Page page1=new Page();
        page1.setRows(list);
        PageInfo<COrderVO> pageInfo=new PageInfo<>(list);
        page1.setTotal(pageInfo.getTotal());
        return page1;
    }

    @Override
    public QueryStatus insert(COrder cOrder) {
        QueryStatus queryStatus=new QueryStatus();
        try {
            int ret=cOrderMapper.insert(cOrder);
            if (ret==1){
                queryStatus.setStatus(200);
                queryStatus.setMsg("ok");
            }
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("新增订单失败，请重试");
        }
        return queryStatus;
    }

    @Override
    public QueryStatus updateByPrimaryKeySelective(COrder cOrder) {
        QueryStatus queryStatus=new QueryStatus();
        try {
            int ret=cOrderMapper.updateByPrimaryKeySelective(cOrder);
            if (ret==1){
                queryStatus.setStatus(200);
                queryStatus.setMsg("ok");
            }
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("修改订单失败，请重试");
        }
        return queryStatus;
    }

    @Override
    public QueryStatus updateNote(COrder cOrder) {
        QueryStatus queryStatus=new QueryStatus();
        int ret=cOrderMapper.updateNote(cOrder);
        if (ret==1){
            queryStatus.setStatus(200);
            queryStatus.setMsg("ok");
        }
        return queryStatus;
    }

    @Override
    public QueryStatus deleteBatchOrder(String[] ids) {
        QueryStatus queryStatus=new QueryStatus();
        try{
            for (String id:ids){
                cOrderMapper.deleteByPrimaryKey(id);
            }
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("删除出现故障，请重新尝试");
        }
        return queryStatus;
    }

    @Override
    public Page searchProductById(String searchValue, int page, int rows) {
        PageHelper.startPage(page,rows);
        List<COrderVO> list= cOrderMapper.searchOrderByOrderId(searchValue);
        Page page1=new Page();
        page1.setRows(list);
        PageInfo<COrderVO> pageInfo=new PageInfo<>(list);
        page1.setTotal(pageInfo.getTotal());
        return page1;
    }

    @Override
    public Page searchOrderByCustom(String searchValue, int page, int rows) {
        PageHelper.startPage(page,rows);
        List<COrderVO> list= cOrderMapper.searchOrderByCustomName(searchValue);
        Page page1=new Page();
        page1.setRows(list);
        PageInfo<COrderVO> pageInfo=new PageInfo<>(list);
        page1.setTotal(pageInfo.getTotal());
        return page1;
    }

    @Override
    public Page searchOrderByPro(String searchValue, int page, int rows) {
        PageHelper.startPage(page,rows);
        List<COrderVO> list= cOrderMapper.searchOrderByProductName(searchValue);
        Page page1=new Page();
        page1.setRows(list);
        PageInfo<COrderVO> pageInfo=new PageInfo<>(list);
        page1.setTotal(pageInfo.getTotal());
        return page1;
    }
}
