
package cn.az.mapper;


import cn.az.bean.FinalMeasuretCheck;
import cn.az.bean.UnqualifyApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UnqualifyApplyMapper {
    //新增
    public int insert(UnqualifyApply ua);
    //修改
    public int updateAll(UnqualifyApply ua);
    //删除
    public void deleteBatch(String[] ids);
    //查询所有（附带分页）
    public List<UnqualifyApply> selectAll();
    //查询id
    public UnqualifyApply selectById(String ids);
    //修改note
    public void updateOne(UnqualifyApply unqualifyApply);
    //查询by value 多表1
    public List<UnqualifyApply> selectRightOne(@Param("searchValueint") String searchValueint);
    //查询by value 多表2
    public List<UnqualifyApply> selectRightTwo(@Param("searchValueint") String searchValueint);
}