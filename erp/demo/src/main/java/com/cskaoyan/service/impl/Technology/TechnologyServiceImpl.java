package com.cskaoyan.service.Impl.Technology;

import com.cskaoyan.bean.Technology.Technology;

import com.cskaoyan.mapper.Technology.TechnologyMapper;
import com.cskaoyan.service.Technology.TechnologyService;
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
    public List<Technology> selectByName(String technologyName) {
        return technologyMapper.selectByName(technologyName);
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
    public List<Technology> selectAll() {
        return technologyMapper.selectAll();
    }
}
