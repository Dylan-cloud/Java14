package com.cskaoyan.service.fault;

import com.cskaoyan.bean.Device_Fault;
import com.cskaoyan.mapper.Device_FaultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Device_FaultServiceImp implements Device_FaultService {
    @Autowired
    Device_FaultMapper device_faultMapper;

    public List<Device_Fault> selectIdAndName() {
        return device_faultMapper.selectIdAndName();
    }

    public int deleteByPrimaryKey(String[] deviceFaultId) {
        int i = device_faultMapper.deleteByPrimaryKey(deviceFaultId);
        return i;
    }

    public int insert(Device_Fault record) {
        return device_faultMapper.insert(record);
    }

    public int insertSelective(Device_Fault record) {
        return device_faultMapper.insertSelective(record);
    }

    public Device_Fault selectByPrimaryKey(String deviceFaultId) {
        return device_faultMapper.selectByPrimaryKey(deviceFaultId);
    }

    public int updateByPrimaryKeySelective(Device_Fault record) {
        return device_faultMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Device_Fault record) {
        return device_faultMapper.updateByPrimaryKey(record);
    }

    public List<Device_Fault> selectAll() {
        return device_faultMapper.selectAll();
    }
}
