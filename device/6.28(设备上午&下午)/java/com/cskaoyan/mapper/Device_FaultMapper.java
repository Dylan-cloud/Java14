package com.cskaoyan.mapper;

import com.cskaoyan.bean.Device_Fault;

import java.util.List;

public interface Device_FaultMapper {
    int deleteByPrimaryKey(String deviceFaultId);

    int insert(Device_Fault record);

    int insertSelective(Device_Fault record);

    Device_Fault selectByPrimaryKey(String deviceFaultId);

    List<Device_Fault> selectAll();

    int updateByPrimaryKeySelective(Device_Fault record);

    int updateByPrimaryKey(Device_Fault record);
}