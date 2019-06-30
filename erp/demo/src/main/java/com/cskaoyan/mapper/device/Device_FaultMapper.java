package com.cskaoyan.mapper.device;

import com.cskaoyan.bean.device.Device_Fault;

import java.util.List;

public interface Device_FaultMapper {
    int deleteByPrimaryKey(String[] deviceFaultId);

    int insert(Device_Fault record);

    int insertSelective(Device_Fault record);

    Device_Fault selectByPrimaryKey(String deviceFaultId);

    List<Device_Fault> selectAll();

    List<Device_Fault> selectIdAndName();

    int updateByPrimaryKeySelective(Device_Fault record);

    int updateByPrimaryKey(Device_Fault record);
}