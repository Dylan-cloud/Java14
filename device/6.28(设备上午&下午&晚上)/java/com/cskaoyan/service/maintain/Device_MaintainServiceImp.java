package com.cskaoyan.service.maintain;

import com.cskaoyan.bean.Device_Maintain;
import com.cskaoyan.mapper.Device_MaintainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Device_MaintainServiceImp implements Device_MaintainService{
    @Autowired
    Device_MaintainMapper device_maintainMapper;

    public int deleteByPrimaryKey(String[] deviceMaintainId) {
        int i = device_maintainMapper.deleteByPrimaryKey(deviceMaintainId);
        return i;
    }

    public int insert(Device_Maintain record) {
        int insert = device_maintainMapper.insert(record);
        return insert;
    }

    public int insertSelective(Device_Maintain record) {
        int i = device_maintainMapper.insertSelective(record);
        return i;
    }

    public Device_Maintain selectByPrimaryKey(String deviceMaintainId) {
        Device_Maintain device_maintain = device_maintainMapper.selectByPrimaryKey(deviceMaintainId);
        return device_maintain;
    }

    public int updateByPrimaryKeySelective(Device_Maintain record) {
        int i = device_maintainMapper.updateByPrimaryKeySelective(record);
        return i;
    }

    public int updateByPrimaryKey(Device_Maintain record) {
        int i = device_maintainMapper.updateByPrimaryKeySelective(record);
        return i;
    }

    public List<Device_Maintain> selectAll() {
        return device_maintainMapper.selectAll();
    }
}
