/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: QualityMapper
 * Author:   Administrator
 * Date:     2019/6/26 16:05
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.az.mapper;


import cn.az.bean.FinalMeasuretCheck;
import cn.az.bean.ProcessMeasureCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessMeasureCheckMapper {
    //新增
    public int insert(ProcessMeasureCheck pmc);
    //修改
    public int updateAll(ProcessMeasureCheck pmc);
    //删除
    public void deleteBatch(String[] ids);
    //查询所有（附带分页）
    public List<ProcessMeasureCheck> selectAll();
    //查询id
    public ProcessMeasureCheck selectById(String ids);
    //修改note
    public void updateOne(ProcessMeasureCheck processMeasureCheck);
    //查询by value 多表1
    public List<ProcessMeasureCheck> selectRightOne(@Param("searchValueint") String searchValueint);
    /*//查询by value 多表2
    public List<FinalMeasuretCheck> selectRightTwo(@Param("searchValueint") String searchValueint);*/
}