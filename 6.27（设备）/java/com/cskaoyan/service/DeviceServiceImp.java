package com.cskaoyan.service;

import com.cskaoyan.bean.Device;
import com.cskaoyan.mapper.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImp implements DeviceService {
    @Autowired
    DeviceMapper deviceMapper;

    public int deleteByPrimaryKey(String deviceId) {
        int i = deviceMapper.deleteByPrimaryKey(deviceId);
        return i;
    }

    public int insert(Device record) {
        int insert = deviceMapper.insert(record);
        return insert;
    }

    public int insertSelective(Device record) {
        int i = deviceMapper.insertSelective(record);
        return i;
    }

    public List<Device> selectByPrimaryKey(String deviceId) {
        List<Device> devices = deviceMapper.selectByPrimaryKey(deviceId);
        return devices;
    }

    public int updateByPrimaryKeySelective(Device record) {
        int i = deviceMapper.updateByPrimaryKeySelective(record);
        return i;
    }

    public int updateByPrimaryKey(Device record) {
        int i = deviceMapper.updateByPrimaryKey(record);
        return i;
    }

    public List<Device> selectAll() {
        return deviceMapper.selectAll();
    }
}
