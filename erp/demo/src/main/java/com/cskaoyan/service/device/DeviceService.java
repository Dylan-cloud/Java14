package com.cskaoyan.service.device;

import com.cskaoyan.bean.device.Device;

import java.util.List;

public interface DeviceService {
    int deleteByPrimaryKey(String[] deviceId);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(String deviceId);

    List<Device> selectAll();

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);
}
