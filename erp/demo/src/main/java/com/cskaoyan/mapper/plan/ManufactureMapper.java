package com.cskaoyan.mapper.plan;

import com.cskaoyan.bean.VO.ManufactureVO;
import com.cskaoyan.bean.plan.Manufacture;

import java.util.List;

public interface ManufactureMapper {
    int deleteByPrimaryKey(String manufactureSn);

    int insert(Manufacture record);

    int insertSelective(Manufacture record);

    ManufactureVO selectByPrimaryKey(String manufactureSn);

    int updateByPrimaryKeySelective(Manufacture record);

    int updateByPrimaryKey(Manufacture record);

    List<ManufactureVO>  find();
    List<ManufactureVO> searchManufactureByManufactureSn(String manufactureSn);
    List<ManufactureVO> searchManufactureByManufactureOrderId(String manufactureOrderId);
    List<ManufactureVO> searchManufactureByManufactureTechnologyName(String technologyName);
}