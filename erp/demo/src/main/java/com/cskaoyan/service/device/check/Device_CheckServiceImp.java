package com.cskaoyan.service.device.check;

import com.cskaoyan.bean.device.Device_Check;
import com.cskaoyan.mapper.device.Device_CheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Device_CheckServiceImp implements Device_CheckService {
    @Autowired
    Device_CheckMapper device_checkMapper;

    public int deleteByPrimaryKey(String[] deviceCheckId) {
        return device_checkMapper.deleteByPrimaryKey(deviceCheckId);
    }

    public int insert(Device_Check record) {
        return device_checkMapper.insert(record);
    }

    public int insertSelective(Device_Check record) {
        return device_checkMapper.insertSelective(record);
    }

    public Device_Check selectByPrimaryKey(String deviceCheckId) {
        return device_checkMapper.selectByPrimaryKey(deviceCheckId);
    }

    public int updateByPrimaryKeySelective(Device_Check record) {
        return device_checkMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Device_Check record) {
        return device_checkMapper.updateByPrimaryKey(record);
    }

    public List<Device_Check> selectAll() {
        return device_checkMapper.selectAll();
    }
}
