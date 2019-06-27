package com.cskaoyan.service.impl;


import com.cskaoyan.bean.Custom;
import com.cskaoyan.bean.Page;
import com.cskaoyan.mapper.CustomMapper;
import com.cskaoyan.service.CustomService;
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
    public int insert(Custom custom) throws Exception {
        int i = customMapper.insert(custom);
        return i;
    }

    @Override
    public int update(Custom custom) throws Exception {
        int i = customMapper.updateByPrimaryKey(custom);
        return i;
    }

    @Override
    public int delete(Custom custom) throws Exception {
        int i = customMapper.deleteByPrimaryKey(custom.getCustomId());
        return i;
    }

    @Override
    public int deleteBatch(String[] ids) throws Exception {
        return customMapper.deleteBatch(ids);
    }

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
