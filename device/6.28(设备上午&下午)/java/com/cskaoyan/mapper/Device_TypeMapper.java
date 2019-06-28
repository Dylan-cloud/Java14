package com.cskaoyan.mapper;

import com.cskaoyan.bean.Device_Type;

import java.util.List;

public interface Device_TypeMapper {
    int deleteByPrimaryKey(String[] deviceTypeId);

    int insert(Device_Type record);

    int insertSelective(Device_Type record);

    Device_Type selectByPrimaryKey(String deviceTypeId);

    List<Device_Type> selectAll();

    int updateByPrimaryKeySelective(Device_Type record);

    int updateByPrimaryKey(Device_Type record);
}