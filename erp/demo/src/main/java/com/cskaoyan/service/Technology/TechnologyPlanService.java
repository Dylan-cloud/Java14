package com.cskaoyan.service.Technology;

import com.cskaoyan.bean.Technology.TechnologyPlan;

import java.util.List;

public interface TechnologyPlanService {

    int deleteByPrimaryKey(String technologyPlanId);

    int insert(TechnologyPlan record);

    int insertSelective(TechnologyPlan record);

    TechnologyPlan selectByPrimaryKey(String technologyPlanId);

    int updateByPrimaryKeySelective(TechnologyPlan record);

    int updateByPrimaryKey(TechnologyPlan record);

    List<TechnologyPlan> selectAll();

    List<TechnologyPlan> selectByName(String searchValue);
}
