package com.cskaoyan.mapper.Technology;

import com.cskaoyan.bean.Technology.TechnologyRequirement;
import com.cskaoyan.bean.Technology.TechnologyRequirementVo;

import java.util.List;

public interface TechnologyRequirementMapper {
    int deleteByPrimaryKey(String technologyRequirementId);

    int insert(TechnologyRequirement record);

    int insertSelective(TechnologyRequirement record);

    TechnologyRequirement selectByPrimaryKey(String technologyRequirementId);

    int updateByPrimaryKeySelective(TechnologyRequirement record);

    int updateByPrimaryKey(TechnologyRequirement record);

    List<TechnologyRequirement> selectAll();

    TechnologyRequirementVo selectTRVByPrimaryKey(String searchValue);

    List<TechnologyRequirementVo> selectTRVByTechnologyName(String searchValue);
}