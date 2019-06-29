package com.cskaoyan.service.plan;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.VO.ManufactureVO;
import com.cskaoyan.bean.plan.Manufacture;

import java.util.List;

/**
 * @Author: TXJ
 * @Date: 2019/6/29 19:43
 * @Version 1.0
 */

public interface ManuService {
    ManufactureVO get(String manuId);

    List<ManufactureVO> find();

    Page findAllManu(int page, int rows);

    QueryStatus insert(Manufacture work);

    QueryStatus update(Manufacture work);

    QueryStatus delete(String id);

    QueryStatus deleteBatchwork(String[] ids);

    Page searchManufactureByManufactureSn(Integer page, Integer rows, String searchValue);

    Page searchManufactureBymanufactureOrderId(Integer page, Integer rows, String searchValue);

    Page searchManufactureBymanufactureTechnologyName(Integer page, Integer rows, String searchValue);
}
