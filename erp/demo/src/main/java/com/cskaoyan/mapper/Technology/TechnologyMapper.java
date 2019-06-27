package com.cskaoyan.mapper.Technology;

import com.cskaoyan.bean.Technology.Technology;

import java.util.List;

public interface TechnologyMapper {
    int deleteByPrimaryKey(String technologyId);

    int insert(Technology record);

    int insertSelective(Technology record);

    Technology selectByPrimaryKey(String technologyId);

    List<Technology> selectByName(String TechnologyName);

    int updateByPrimaryKeySelective(Technology record);

    int updateByPrimaryKey(Technology record);

    List<Technology> selectAll();
}