package com.cskaoyan.service.plan;

import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.plan.Custom;
import com.cskaoyan.bean.Page;
import com.cskaoyan.exception.CustomException;

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
    Page searchCustomById(String searchValue,int page,int rows);
    Page searchCustomByName(String searchValue, int page, int rows);
    Custom get(String string)throws Exception;
    //增删改都需要返回状态对象
    QueryStatus insert(Custom custom);
    QueryStatus update(Custom custom);
    QueryStatus deleteBatch(String[] ids) throws CustomException;


    QueryStatus updatenote(Custom custom);
}
