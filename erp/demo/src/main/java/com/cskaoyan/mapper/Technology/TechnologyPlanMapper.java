package com.cskaoyan.mapper.Technology;

import com.cskaoyan.bean.Technology.TechnologyPlan;

import java.util.List;

public interface TechnologyPlanMapper {
    int deleteByPrimaryKey(String technologyPlanId);

    int insert(TechnologyPlan record);

    int insertSelective(TechnologyPlan record);

    TechnologyPlan selectByPrimaryKey(String technologyPlanId);

    List<TechnologyPlan> selectByName(String searchValue);

    int updateByPrimaryKeySelective(TechnologyPlan record);

    int updateByPrimaryKey(TechnologyPlan record);

    List<TechnologyPlan> selectAll();
}