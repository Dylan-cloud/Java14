package com.cskaoyan.service.Impl.Technology;

import com.cskaoyan.bean.Technology.Technology;
import com.cskaoyan.mapper.Technology.TechnologyMapper;
import com.cskaoyan.service.Technology.TechnologyService;
import com.cskaoyan.util.EUDataGridResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyServiceImpl implements TechnologyService {

    @Autowired
    TechnologyMapper technologyMapper;

    @Override
    public int deleteByPrimaryKey(String technologyId) {
        return technologyMapper.deleteByPrimaryKey(technologyId);
    }

    @Override
    public int insert(Technology record) {
        return technologyMapper.insert(record);
    }

    @Override
    public int insertSelective(Technology record) {
        return technologyMapper.insertSelective(record);
    }

    @Override
    public Technology selectByPrimaryKey(String technologyId) {
        return technologyMapper.selectByPrimaryKey(technologyId);
    }

    @Override
    public int updateByPrimaryKeySelective(Technology record) {
        return technologyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Technology record) {
        return technologyMapper.updateByPrimaryKey(record);
    }

    @Override
    public EUDataGridResult selectPageTechnology(int page, int rows) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<Technology> list = technologyMapper.selectAll();
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<Technology> pageInfo = new PageInfo<>(list);
        result.setTotal(list.size());
        return result;
    }

    @Override
    public List<Technology> selectAll() {
        return technologyMapper.selectAll();
    }

    @Override
    public List<Technology> selectByTechnologyName(String searchValue) {
        return technologyMapper.selectByTechnologyName(searchValue);
    }
}
