package com.cskaoyan.mapper.plan;

import com.cskaoyan.bean.VO.COrderVO;
import com.cskaoyan.bean.plan.COrder;

import java.util.List;

public interface COrderMapper {
    List<COrderVO> find();

    List<COrderVO> searchOrderByOrderId(String orderId);
    List<COrderVO> searchOrderByCustomName(String customName);
    List<COrderVO> searchOrderByProductName(String productName);

    int updateNote(COrder cOrder);

    int deleteByPrimaryKey(String orderId);

    int insert(COrder record);

    int insertSelective(COrder record);

    COrder selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(COrder record);

    int updateByPrimaryKey(COrder record);
}