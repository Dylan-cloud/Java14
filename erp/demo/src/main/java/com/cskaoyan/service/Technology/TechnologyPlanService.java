package com.cskaoyan.service.Technology;

import com.cskaoyan.bean.Technology.TechnologyPlan;
import com.cskaoyan.bean.Technology.TechnologyPlanVo;
import com.cskaoyan.util.EUDataGridResult;

import java.util.List;

public interface TechnologyPlanService {

    int deleteByPrimaryKey(String technologyPlanId);

    int insert(TechnologyPlan record);

    int insertSelective(TechnologyPlan record);

    TechnologyPlan selectByPrimaryKey(String technologyPlanId);

    int updateByPrimaryKeySelective(TechnologyPlan record);

    int updateByPrimaryKey(TechnologyPlan record);

    EUDataGridResult selectPageTechnology(int page, int rows);

    TechnologyPlanVo selectTechnologyPlanVo(String technologyPlanId);

    List<TechnologyPlan> selectAll();

    List<TechnologyPlanVo> selectTPVByTechnologyName(String searchValue);

    TechnologyPlanVo selectTPVByPrimaryKey(String searchValue);
}
