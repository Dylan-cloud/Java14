/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: FinalCountCheckService
 * Author:   Administrator
 * Date:     2019/6/26 18:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.az.service;

import cn.az.bean.Data;
import cn.az.bean.EUDataGridResult;
import cn.az.bean.FinalMeasuretCheck;
import cn.az.bean.UnqualifyApply;
import cn.az.mapper.FinalMeasuretCheckMapper;
import cn.az.mapper.UnqualifyApplyMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UnqualifyApplyService {
    @Autowired
    UnqualifyApplyMapper unqualifyApplyMapper;
    //新增功能
    public Data insert(UnqualifyApply unqualifyApply) {
        Data data = new Data();
        unqualifyApplyMapper.insert(unqualifyApply);
        UnqualifyApply finalMeasuretCheck = selectById(unqualifyApply.getUnqualifyApplyId());
        if(finalMeasuretCheck!=null){
            data.setMsg("OK");
            data.setStatus(200);
        }else{
            data.setMsg("该成品计数质检编号已经存在，请更换！");
            data.setStatus(0);}
        return data;
    }

    //修改功能
    public Data updateAll(UnqualifyApply unqualifyApply) {
        unqualifyApplyMapper.updateAll(unqualifyApply);
        Data data = new Data(200,"OK");
        return data;
    }

    public Data updateOne(UnqualifyApply unqualifyApply) {
        unqualifyApplyMapper.updateOne(unqualifyApply);
        Data data = new Data(200,"OK");
        return data;
    }
    //删除功能
    public Data deleteBatch(String[] ids) {
        unqualifyApplyMapper.deleteBatch(ids);
        Data data = new Data(200,"OK");
        return data;
    }

    //查询
    public List<UnqualifyApply> selectAll() {
        List<UnqualifyApply> unqualifyApplies = unqualifyApplyMapper.selectAll();
        return unqualifyApplies;
    }
    //查询id
    public UnqualifyApply selectById(String ids) {
        UnqualifyApply unqualifyApply = unqualifyApplyMapper.selectById(ids);
        return unqualifyApply;
    }
    //分页查询
    public EUDataGridResult getItemList(int page, int rows) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<UnqualifyApply> list = unqualifyApplyMapper.selectAll();
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<UnqualifyApply> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    //多表查询-右上角按键1
    public EUDataGridResult getItemList1(String searchValueint , int page, int rows) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<UnqualifyApply> list = unqualifyApplyMapper.selectRightOne(searchValueint);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<UnqualifyApply> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
    //多表查询-右上角按键2
    public EUDataGridResult getItemList2(String searchValueint , int page, int rows) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<UnqualifyApply> list = unqualifyApplyMapper.selectRightTwo(searchValueint);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<UnqualifyApply> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }


}