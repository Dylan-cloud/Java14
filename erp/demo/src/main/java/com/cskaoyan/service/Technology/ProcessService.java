package com.cskaoyan.service.Technology;

import com.cskaoyan.bean.Technology.Process;
import com.cskaoyan.bean.Technology.TechnologyPlan;
import com.cskaoyan.util.EUDataGridResult;

import java.util.List;

public interface ProcessService {

    int deleteByPrimaryKey(String processId);

    int insert(Process record);

    int insertSelective(Process record);

    Process selectByPrimaryKey(String processId);

    int updateByPrimaryKeySelective(Process record);

    int updateByPrimaryKey(Process record);

    EUDataGridResult selectPageTechnology(int page, int rows);

    List<TechnologyPlan> findAll();

    Process selectProcessById(String searchValue);

    List<Process> selectProcessByTechnologyId(String searchValue);
}
