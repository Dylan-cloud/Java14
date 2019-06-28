package com.cskaoyan.service.Technology;

import com.cskaoyan.bean.Technology.TechnologyPlan;
import com.cskaoyan.util.EUDataGridResult;

public interface TechnologyPlanService {

    int deleteByPrimaryKey(String technologyPlanId);

    int insert(TechnologyPlan record);

    int insertSelective(TechnologyPlan record);

    TechnologyPlan selectByPrimaryKey(String technologyPlanId);

    int updateByPrimaryKeySelective(TechnologyPlan record);

    int updateByPrimaryKey(TechnologyPlan record);

    EUDataGridResult selectPageTechnology(int page, int rows);
}
