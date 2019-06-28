package com.cskaoyan.service.Impl.Technology;

import com.cskaoyan.bean.Technology.Technology;
import com.cskaoyan.bean.Technology.TechnologyPlan;
import com.cskaoyan.mapper.Technology.TechnologyPlanMapper;
import com.cskaoyan.service.Technology.TechnologyPlanService;
import com.cskaoyan.util.EUDataGridResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public EUDataGridResult selectPageTechnology(int page, int rows) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<TechnologyPlan> list = technologyPlanMapper.selectAll();
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<TechnologyPlan> pageInfo = new PageInfo<>(list);
        result.setTotal(list.size());
        return result;
    }
}
