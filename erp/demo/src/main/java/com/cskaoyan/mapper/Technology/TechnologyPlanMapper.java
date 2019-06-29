package com.cskaoyan.mapper.Technology;

import com.cskaoyan.bean.Technology.TechnologyPlan;
import com.cskaoyan.bean.Technology.TechnologyPlanVo;
import com.cskaoyan.bean.Technology.TechnologyRequirementVo;

import java.util.List;

public interface TechnologyPlanMapper {
    int deleteByPrimaryKey(String technologyPlanId);

    int insert(TechnologyPlan record);

    int insertSelective(TechnologyPlan record);

    TechnologyPlan selectByPrimaryKey(String technologyPlanId);

    int updateByPrimaryKeySelective(TechnologyPlan record);

    int updateByPrimaryKey(TechnologyPlan record);

    List<TechnologyPlan> selectAll();

    TechnologyPlanVo selectTechnologyPlanVo(String technologyPlanId);

    List<TechnologyPlanVo> selectTPVByTechnologyName(String searchValue);

}