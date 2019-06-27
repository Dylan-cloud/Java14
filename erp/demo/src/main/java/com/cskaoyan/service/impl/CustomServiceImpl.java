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
        List<Custom> customs=customMapper.findAll();
        return customs;
    }

    @Override
    public Page getList(int page, int rows, Custom custom) throws Exception {
        //开始分页处理
        PageHelper.startPage(page,rows);
        List<Custom> list=customMapper.findAll();
        Page page1=new Page();
        //设置行数
        page1.setRows(list);
        //取记录的总条数
        PageInfo<Custom> pageInfo=new PageInfo<>(list);
        page1.setTotal(pageInfo.getTotal());
        return page1;
    }

    @Override
    public Custom get(String string) throws Exception {
        return null;
    }
}
