package com.cskaoyan.mapper.device;

import com.cskaoyan.bean.device.Device_Type;

import java.util.List;

public interface Device_TypeMapper {
    int deleteByPrimaryKey(String[] deviceTypeId);

    int insert(Device_Type record);

    int insertSelective(Device_Type record);

    Device_Type selectByPrimaryKey(String deviceTypeId);

    List<Device_Type> selectAll();

    List<Device_Type> selectIdAndName();

    int updateByPrimaryKeySelective(Device_Type record);

    int updateByPrimaryKey(Device_Type record);
}