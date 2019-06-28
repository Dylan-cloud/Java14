package com.cskaoyan.service.Impl.Technology;

import com.cskaoyan.bean.Technology.TechnologyRequirement;
import com.cskaoyan.mapper.Technology.TechnologyRequirementMapper;
import com.cskaoyan.service.Technology.TechnologyRequirementService;
import com.cskaoyan.util.EUDataGridResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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

    @Override
    public EUDataGridResult selectPageTechnology(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<TechnologyRequirement> list = technologyRequirementMapper.selectAll();
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<TechnologyRequirement> pageInfo = new PageInfo<>(list);
        result.setTotal(list.size());
        return result;
    }
}
