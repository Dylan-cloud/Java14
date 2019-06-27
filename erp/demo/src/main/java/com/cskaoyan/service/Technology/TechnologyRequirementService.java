package com.cskaoyan.service.Technology;

import com.cskaoyan.bean.Technology.TechnologyRequirement;

import java.util.List;

public interface TechnologyRequirementService {

    int deleteByPrimaryKey(String technologyRequirementId);

    int insert(TechnologyRequirement record);

    int insertSelective(TechnologyRequirement record);

    TechnologyRequirement selectByPrimaryKey(String technologyRequirementId);

    int updateByPrimaryKeySelective(TechnologyRequirement record);

    int updateByPrimaryKey(TechnologyRequirement record);

    List<TechnologyRequirement> selectAll();
}
