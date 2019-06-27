package com.cskaoyan.service.Impl.Technology;

import com.cskaoyan.bean.Technology.TechnologyRequirement;
import com.cskaoyan.mapper.Technology.TechnologyRequirementMapper;
import com.cskaoyan.service.Technology.TechnologyRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechnologyRequirementServiceImpl implements TechnologyRequirementService {

    @Autowired
    TechnologyRequirementMapper technologyRequirementMapper;

    @Override
    public int deleteByPrimaryKey(String technologyRequirementId) {
        return technologyRequirementMapper.deleteByPrimaryKey(technologyRequirementId);
    }

    @Override
    public int insert(TechnologyRequirement record) {
        return technologyRequirementMapper.insert(record);
    }

    @Override
    public int insertSelective(TechnologyRequirement record) {
        return technologyRequirementMapper.insertSelective(record);
    }

    @Override
    public TechnologyRequirement selectByPrimaryKey(String technologyRequirementId) {
        return technologyRequirementMapper.selectByPrimaryKey(technologyRequirementId);
    }

    @Override
    public int updateByPrimaryKeySelective(TechnologyRequirement record) {
        return technologyRequirementMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TechnologyRequirement record) {
        return technologyRequirementMapper.updateByPrimaryKey(record);
    }
}
