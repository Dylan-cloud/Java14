package com.cskaoyan.mapper.Technology;

import com.cskaoyan.bean.Technology.Technology;

import java.util.List;

public interface TechnologyMapper {
    int deleteByPrimaryKey(String technologyId);

    int insert(Technology record);

    int insertSelective(Technology record);

    Technology selectByPrimaryKey(String technologyId);

    int updateByPrimaryKeySelective(Technology record);

    int updateByPrimaryKey(Technology record);

    List<Technology> selectAll();

    List<Technology> selectByTechnologyName(String searchValue);
}