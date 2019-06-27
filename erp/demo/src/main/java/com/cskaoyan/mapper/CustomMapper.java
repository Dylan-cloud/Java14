package com.cskaoyan.mapper;

import com.cskaoyan.bean.Custom;

import java.util.List;

public interface CustomMapper {
    //扩展的mapper接口方法
    //删除
    int deleteBatch(String[] ids);
    //展示所有
    List<Custom> findAll();
    //搜索
    List<Custom> searchCustomByCustomName(String custonName);
    List<Custom> searchCustomByCustomId(String customId);
    //逆向生成的接口方法
    int deleteByPrimaryKey(String customId);

    int insert(Custom record);
    //直接可用的插入
    int insertSelective(Custom record);

    Custom selectByPrimaryKey(String customId);

    int updateByPrimaryKeySelective(Custom record);
    //直接可用的修改
    int updateByPrimaryKey(Custom record);
}