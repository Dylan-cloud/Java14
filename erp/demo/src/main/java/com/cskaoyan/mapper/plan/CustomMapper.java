package com.cskaoyan.mapper.plan;

import com.cskaoyan.bean.plan.Custom;

import java.util.List;

public interface CustomMapper {
    //扩展的mapper接口方法


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
    int updateNote(Custom custom);
    int updateByPrimaryKeySelective(Custom record);
    //直接可用的修改
    int updateByPrimaryKey(Custom record);
}