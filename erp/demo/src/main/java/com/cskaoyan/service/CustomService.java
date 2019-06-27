package com.cskaoyan.service;

import com.cskaoyan.bean.Custom;
import com.cskaoyan.bean.Page;

import java.util.List;

/**
 * @Author: TXJ
 * @Date: 2019/6/27 11:59
 * @Version 1.0
 */
public interface CustomService {
    //返回所有的custom对象
    List<Custom> find() throws Exception;
    //得到page对象
    Page getList(int page,int rows,Custom custom)throws Exception;
    Custom get(String string)throws Exception;


}
