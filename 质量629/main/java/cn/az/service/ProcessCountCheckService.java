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
import cn.az.bean.FinalCountCheck;
import cn.az.bean.ProcessCountCheck;
import cn.az.mapper.FinalCountCheckMapper;
import cn.az.mapper.ProcessCountCheckMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProcessCountCheckService {
    @Autowired
    ProcessCountCheckMapper processCountCheckMapper;
    //新增功能
    public Data insert(ProcessCountCheck processCountCheck) {
        Data data = new Data();
        processCountCheckMapper.insert(processCountCheck);
        ProcessCountCheck processCountCheck1 = selectById(processCountCheck.getpCountCheckId());
        if(processCountCheck1!=null){
            data.setMsg("OK");
            data.setStatus(200);
        }else{
            data.setMsg("该成品计数质检编号已经存在，请更换！");
            data.setStatus(0);}
        return data;
    }

    //修改功能
    public Data updateAll(ProcessCountCheck processCountCheck) {
        processCountCheckMapper.updateAll(processCountCheck);
        Data data = new Data(200,"OK");
        return data;
    }

    public Data updateOne(ProcessCountCheck processCountCheck) {
        processCountCheckMapper.updateOne(processCountCheck);
        Data data = new Data(200,"OK");
        return data;
    }
    //删除功能
    public Data deleteBatch(String[] ids) {
        processCountCheckMapper.deleteBatch(ids);
        Data data = new Data(200,"OK");
        return data;
    }

    //查询
    public List<ProcessCountCheck> selectAll() {
        List<ProcessCountCheck> processCountChecks = processCountCheckMapper.selectAll();
        return processCountChecks;
    }
    //查询id
    public ProcessCountCheck selectById(String ids) {
        ProcessCountCheck processCountCheck = processCountCheckMapper.selectById(ids);
        return processCountCheck;
    }
    //分页查询
    public EUDataGridResult getItemList(int page, int rows) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<ProcessCountCheck> list = processCountCheckMapper.selectAll();
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<ProcessCountCheck> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    //多表查询-右上角按键1
    public EUDataGridResult getItemList1(String searchValueint , int page, int rows) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<ProcessCountCheck> list = processCountCheckMapper.selectRightOne(searchValueint);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<ProcessCountCheck> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
    /*//多表查询-右上角按键2
    public EUDataGridResult getItemList2(String searchValueint , int page, int rows) {
        //分页处理
        PageHelper.startPage(page, rows);
        List<FinalCountCheck> list = finalCountCheckMapper.selectRightTwo(searchValueint);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<FinalCountCheck> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }*/


}