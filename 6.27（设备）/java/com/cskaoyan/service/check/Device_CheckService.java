package com.cskaoyan.service.check;

import com.cskaoyan.bean.Device_Check;

public interface Device_CheckService {
    int deleteByPrimaryKey(String deviceCheckId);

    int insert(Device_Check record);

    int insertSelective(Device_Check record);

    Device_Check selectByPrimaryKey(String deviceCheckId);

    int updateByPrimaryKeySelective(Device_Check record);

    int updateByPrimaryKey(Device_Check record);
}
