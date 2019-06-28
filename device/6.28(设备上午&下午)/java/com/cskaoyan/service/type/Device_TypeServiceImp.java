package com.cskaoyan.service.type;


import com.cskaoyan.bean.Device_Type;
import com.cskaoyan.mapper.Device_TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Device_TypeServiceImp implements Device_TypeService {
    @Autowired
    Device_TypeMapper device_typeMapper;

    public int deleteByPrimaryKey(String[] deviceTypeId) {
        int i = device_typeMapper.deleteByPrimaryKey(deviceTypeId);
        return i;
    }

    public int insert(Device_Type record) {
        int insert = device_typeMapper.insert(record);
        return insert;
    }

    public int insertSelective(Device_Type record) {
        int i = device_typeMapper.insertSelective(record);
        return i;
    }

    public Device_Type selectByPrimaryKey(String deviceTypeId) {
        Device_Type device_type = device_typeMapper.selectByPrimaryKey(deviceTypeId);
        return device_type;
    }

    public int updateByPrimaryKeySelective(Device_Type record) {
        int i = device_typeMapper.updateByPrimaryKeySelective(record);
        return i;
    }

    public int updateByPrimaryKey(Device_Type record) {
        int i = device_typeMapper.updateByPrimaryKey(record);
        return i;
    }

    public List<Device_Type> selectAll() {
        return device_typeMapper.selectAll();
    }
}
