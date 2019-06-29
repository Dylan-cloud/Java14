package com.cskaoyan.mapper.plan;

import com.cskaoyan.bean.VO.WorkVO;
import com.cskaoyan.bean.plan.Work;

import java.util.List;

public interface WorkMapper {


    List<WorkVO> searchWorkByWorkId(String workId);

    List<WorkVO> searchWorkByWorkProduct(String workProduct);

    List<WorkVO> searchWorkByWorkDevice(String workDevice);

    List<WorkVO> searchWorkByWorkProcess(String workProcess);
    int deleteByPrimaryKey(String workId);

    int insert(Work record);

    int insertSelective(Work record);

    WorkVO selectByPrimaryKey(String workId);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);

    List<WorkVO> findAllWork();
}