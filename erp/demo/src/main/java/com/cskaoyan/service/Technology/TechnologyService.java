package com.cskaoyan.service.Technology;

import com.cskaoyan.bean.Technology.Technology;
import com.cskaoyan.util.EUDataGridResult;

import java.util.List;

public interface TechnologyService {

    int deleteByPrimaryKey(String technologyId);

    int insert(Technology record);

    int insertSelective(Technology record);

    Technology selectByPrimaryKey(String technologyId);

    int updateByPrimaryKeySelective(Technology record);

    int updateByPrimaryKey(Technology record);

    EUDataGridResult selectPageTechnology(int page, int rows);
}
