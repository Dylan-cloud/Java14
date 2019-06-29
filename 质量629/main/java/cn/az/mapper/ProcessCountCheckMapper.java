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
import cn.az.bean.ProcessCountCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessCountCheckMapper {
    //新增
    public int insert(ProcessCountCheck pcc);
    //修改
    public int updateAll(ProcessCountCheck pcc);
    //删除
    public void deleteBatch(String[] ids);
    //查询所有（附带分页）
    public List<ProcessCountCheck> selectAll();
    //查询id
    public ProcessCountCheck selectById(String ids);
    //修改note
    public void updateOne(ProcessCountCheck processCountCheck);
    //查询by value 多表1
    public List<ProcessCountCheck> selectRightOne(@Param("searchValueint") String searchValueint);
    /*//查询by value 多表2
    public List<ProcessCountCheck> selectRightTwo(@Param("searchValueint") String searchValueint);*/
}