package com.cskaoyan.mapper;

import com.cskaoyan.bean.Custom;

import java.util.List;

public interface CustomMapper {
    //扩展的mapper接口方法
    int deleteBatch(String[] ids);
    int changeStatus(String[] ids);
    int updateNote(Custom custom);
    List<Custom> findAll();
    List<Custom> searchCustomByCustomName(String custonName);
    List<Custom> searchCustomByCustomId(String customId);
    //逆向生成的接口方法
    int deleteByPrimaryKey(String customId);

    int insert(Custom record);

    int insertSelective(Custom record);

    Custom selectByPrimaryKey(String customId);

    int updateByPrimaryKeySelective(Custom record);

    int updateByPrimaryKey(Custom record);
}