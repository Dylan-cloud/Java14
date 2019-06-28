package com.cskaoyan.service;

import com.cskaoyan.bean.Device;

import java.util.List;

public interface DeviceService {
    int deleteByPrimaryKey(String deviceId);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(String deviceId);

    List<Device> selectAll();

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);
}
