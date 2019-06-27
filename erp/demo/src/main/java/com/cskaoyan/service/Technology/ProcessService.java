package com.cskaoyan.service.Technology;

import com.cskaoyan.bean.Technology.Process;

import java.util.List;

public interface ProcessService {

    int deleteByPrimaryKey(String processId);

    int insert(Process record);

    int insertSelective(Process record);

    Process selectByPrimaryKey(String processId);

    int updateByPrimaryKeySelective(Process record);

    int updateByPrimaryKey(Process record);

    List<Process> selectAll();
}
