package com.cskaoyan.mapper.device;

import com.cskaoyan.bean.device.Device_Check;

import java.util.List;

public interface Device_CheckMapper {
    int deleteByPrimaryKey(String[] deviceCheckId);

    int insert(Device_Check record);

    int insertSelective(Device_Check record);

    Device_Check selectByPrimaryKey(String deviceCheckId);

    List<Device_Check> selectAll();

    int updateByPrimaryKeySelective(Device_Check record);

    int updateByPrimaryKey(Device_Check record);
}