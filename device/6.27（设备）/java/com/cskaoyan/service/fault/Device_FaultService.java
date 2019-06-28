package com.cskaoyan.service.fault;

import com.cskaoyan.bean.Device_Fault;

public interface Device_FaultService {
    int deleteByPrimaryKey(String deviceFaultId);

    int insert(Device_Fault record);

    int insertSelective(Device_Fault record);

    Device_Fault selectByPrimaryKey(String deviceFaultId);

    int updateByPrimaryKeySelective(Device_Fault record);

    int updateByPrimaryKey(Device_Fault record);
}
