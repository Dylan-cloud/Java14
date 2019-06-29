/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: FinalCountCheck
 * Author:   Administrator
 * Date:     2019/6/26 17:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.az.mapper;


import cn.az.bean.FinalCountCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinalCountCheckMapper {
    //新增
    public int insert(FinalCountCheck fcc);
    //修改
    public int updateAll(FinalCountCheck fcc);
    //删除
    public void deleteBatch(String[] ids);
    //查询所有（附带分页）
    public List<FinalCountCheck> selectAll();
    //查询id
    public FinalCountCheck selectById(String ids);
    //修改note
    public void updateOne(FinalCountCheck finalCountCheck);
    //查询by value 多表1
    public List<FinalCountCheck> selectRightOne(@Param("searchValueint") String searchValueint);
    //查询by value 多表2
    public List<FinalCountCheck> selectRightTwo(@Param("searchValueint") String searchValueint);
}