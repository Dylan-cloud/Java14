package com.cskaoyan.mapper;

import com.cskaoyan.bean.Device;

import java.util.List;

public interface DeviceMapper {
    int deleteByPrimaryKey(String[] devId);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(String deviceId);

    List<Device> selectAll();

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);
}