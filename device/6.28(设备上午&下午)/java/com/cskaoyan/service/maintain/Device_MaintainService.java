package com.cskaoyan.service.maintain;

import com.cskaoyan.bean.Device_Maintain;

import java.util.List;

public interface Device_MaintainService {
    int deleteByPrimaryKey(String deviceMaintainId);

    int insert(Device_Maintain record);

    int insertSelective(Device_Maintain record);

    Device_Maintain selectByPrimaryKey(String deviceMaintainId);

    List<Device_Maintain> selectAll();

    int updateByPrimaryKeySelective(Device_Maintain record);

    int updateByPrimaryKey(Device_Maintain record);
}
