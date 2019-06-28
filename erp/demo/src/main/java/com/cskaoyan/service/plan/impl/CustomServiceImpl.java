package com.cskaoyan.service.plan.impl;


import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.plan.Custom;
import com.cskaoyan.bean.Page;
import com.cskaoyan.exception.CustomException;
import com.cskaoyan.mapper.plan.CustomMapper;
import com.cskaoyan.service.plan.CustomService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: TXJ
 * @Date: 2019/6/26 23:19
 * @Version 1.0
 */

@Service
public class CustomServiceImpl implements CustomService {
    @Autowired
    CustomMapper customMapper;

    @Override
    public List<Custom> find() throws Exception {
        List<Custom> customs = customMapper.findAll();
        return customs;
    }

    @Override
    public Page getList(int page, int rows, Custom custom) throws Exception {
        //开始分页处理
        PageHelper.startPage(page, rows);
        List<Custom> list = customMapper.findAll();
        Page page1 = new Page();
        //设置行数
//        page1.setRows(list);
        //取记录的总条数
        PageInfo<Custom> pageInfo = new PageInfo<>(list);
        page1.setTotal(pageInfo.getTotal());
        page1.setRows(pageInfo.getList());
        return page1;
    }

    @Override
    public Custom get(String string) throws Exception {
        return null;
    }

    @Override
    public QueryStatus insert(Custom custom){
       QueryStatus queryStatus=new QueryStatus();
       try {
           int ret=customMapper.insert(custom);//异常语句
           if (ret==1){
               queryStatus.setStatus(200);
               queryStatus.setMsg("ok");
           }
       }catch (Exception e){
           queryStatus.setStatus(0);
           queryStatus.setMsg("该客户编号已存在，请更换编号");
       }

       return queryStatus;
    }

    @Override
    public QueryStatus update(Custom custom){
        QueryStatus queryStatus=new QueryStatus();
        try {
            int ret=customMapper.updateByPrimaryKeySelective(custom);
            if (ret==1){
                queryStatus.setStatus(200);
                queryStatus.setMsg("ok");
            }
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("该客户编号已存在，请更换客户编号");
        }
        return queryStatus;
    }

    @Override
    public QueryStatus updatenote(Custom custom) {
        QueryStatus queryStatus=new QueryStatus();
        int ret=customMapper.updateNote(custom);
        if (ret==1){
            queryStatus.setStatus(200);
            queryStatus.setMsg("ok");
        }
        return queryStatus;
    }

    @Override
    public QueryStatus deleteBatch(String[] ids) throws CustomException {
        QueryStatus queryStatus=new QueryStatus();
        try{
            for (String id:ids){
                customMapper.deleteByPrimaryKey(id);
            }
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("删除出现故障，请重新尝试");
            throw new CustomException("删除出现故障，请重新尝试");
        }
        return queryStatus;
    }

    //按ID查找
    @Override
    public Page searchCustomById(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Custom> list = customMapper.searchCustomByCustomId(searchValue);
        Page page1 = new Page();
        //设置行数
        page1.setRows(list);
        //取记录的总条数
        PageInfo<Custom> pageInfo = new PageInfo<>(list);
        page1.setTotal(pageInfo.getTotal());
        return page1;
    }

    //按用户名查找
    @Override
    public Page searchCustomByName(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Custom> list = customMapper.searchCustomByCustomName(searchValue);
        Page page1 = new Page();
        //设置行数
        page1.setRows(list);
        //取记录的总条数
        PageInfo<Custom> pageInfo = new PageInfo<>(list);
        page1.setTotal(pageInfo.getTotal());
        return page1;
    }
}
