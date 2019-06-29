package cn.az.controller;

import cn.az.bean.Data;
import cn.az.bean.EUDataGridResult;
import cn.az.bean.FinalMeasuretCheck;
import cn.az.bean.ProcessMeasureCheck;
import cn.az.service.FinalMeasuretCheckService;
import cn.az.service.ProcessMeasureCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ProcessMeasureCheckController {

    @Autowired
    ProcessMeasureCheckService processMeasureCheckService;

    //处理judge
    @ResponseBody
    @RequestMapping(value = {"/pMeasureCheck/add_judge", "/pMeasureCheck/delete_judge", "/pMeasureCheck/edit_judge"})
    public Data judge() {
        return new Data();
    }
//erp/p_measure_check/list?page=1&rows=10
    //find to list
    @RequestMapping("/p_measure_check/find")
    public String toList() {
        return "/WEB-INF/jsp/p_measure_check_list.jsp";
    }

    //新增跳转页面
    @RequestMapping({"/p_measure_check/add"})
    public String add() {
        return "/WEB-INF/jsp/p_measure_check_add.jsp";
    }

    //新增功能
    @ResponseBody
    @RequestMapping("/p_measure_check/insert")
    public Data insert(ProcessMeasureCheck processMeasureCheck) {
        Data data = processMeasureCheckService.insert(processMeasureCheck);
        return data;
    }

    //跳转修改页面
    @RequestMapping(value = {"p_measure_check/edit"}, method = RequestMethod.GET)
    public String edit() {
        return "/WEB-INF/jsp/p_measure_check_edit.jsp";
    }

    //修改功能
    @ResponseBody
    @RequestMapping("/p_measure_check/update_all")
    public Data updateAll(ProcessMeasureCheck processMeasureCheck) {
        Data data = processMeasureCheckService.updateAll(processMeasureCheck);
        return data;
    }

    //修改note功能
    @ResponseBody
    @RequestMapping("/p_measure_check/update_note")
    public Data updateOne(ProcessMeasureCheck processMeasureCheck) {
        Data data = processMeasureCheckService.updateOne(processMeasureCheck);
        return data;
    }


    //删除功能
    @ResponseBody
    @RequestMapping(value = "/p_measure_check/delete_batch")
    public Data deleteBatch(String[] ids) {
        Data data = processMeasureCheckService.deleteBatch(ids);
        return data;
    }

    //    查询-分页
    @ResponseBody
    @RequestMapping("/p_measure_check/list")
    public EUDataGridResult selectAll(int page, int rows) {
        EUDataGridResult result = processMeasureCheckService.getItemList(page, rows);
        return result;
    }

//p_measure_check/search_pMeasureCheck_by_pMeasureCheckId?searchValue=1&page=1&rows=10 HTTP/1.1
    //多表查询-右上角按键1
    @ResponseBody
    @RequestMapping("/p_measure_check/search_pMeasureCheck_by_pMeasureCheckId")
    public EUDataGridResult selectRightOne(String searchValue,int page, int rows) {
        EUDataGridResult result = processMeasureCheckService.getItemList1(searchValue,page, rows);
        return result;
    }
   /* //多表查询-右上角按键2
    @ResponseBody
    @RequestMapping("/measure/search_fMeasureCheck_by_orderId")
    public EUDataGridResult selectRightTwo(String searchValue, int page, int rows) {
        EUDataGridResult result = finalMeasuretCheckService.getItemList2(searchValue, page, rows);
        return result;
    }*/

}