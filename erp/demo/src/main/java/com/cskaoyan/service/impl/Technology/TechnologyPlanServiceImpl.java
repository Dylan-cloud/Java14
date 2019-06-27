package com.cskaoyan.service.Impl.Technology;

import com.cskaoyan.bean.Technology.TechnologyPlan;
import com.cskaoyan.mapper.Technology.TechnologyPlanMapper;
import com.cskaoyan.service.Technology.TechnologyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechnologyPlanServiceImpl implements TechnologyPlanService {

    @Autowired
    TechnologyPlanMapper technologyPlanMapper;

    @Override
    public int deleteByPrimaryKey(String technologyPlanId) {
        return technologyPlanMapper.deleteByPrimaryKey(technologyPlanId);
    }

    @Override
    public int insert(TechnologyPlan record) {
        return technologyPlanMapper.insert(record);
    }

    @Override
    public int insertSelective(TechnologyPlan record) {
        return technologyPlanMapper.insertSelective(record);
    }

    @Override
    public TechnologyPlan selectByPrimaryKey(String technologyPlanId) {
        return technologyPlanMapper.selectByPrimaryKey(technologyPlanId);
    }

    @Override
    public int updateByPrimaryKeySelective(TechnologyPlan record) {
        return technologyPlanMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TechnologyPlan record) {
        return technologyPlanMapper.updateByPrimaryKey(record);
    }
}
