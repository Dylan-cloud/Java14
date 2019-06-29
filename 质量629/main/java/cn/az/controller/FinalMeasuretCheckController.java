package cn.az.controller;

import cn.az.bean.Data;
import cn.az.bean.EUDataGridResult;
import cn.az.bean.FinalCountCheck;
import cn.az.bean.FinalMeasuretCheck;
import cn.az.service.FinalCountCheckService;
import cn.az.service.FinalMeasuretCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class FinalMeasuretCheckController {

    @Autowired
    FinalMeasuretCheckService finalMeasuretCheckService;

    //处理judge
    @ResponseBody
    @RequestMapping(value = {"/fMeasureCheck/add_judge", "/fMeasureCheck/delete_judge", "/fMeasureCheck/edit_judge"})
    public Data judge() {
        return new Data();
    }

    //find to list
    @RequestMapping("/measure/find")
    public String toList() {
        return "/WEB-INF/jsp/measurement_list.jsp";
    }

    //新增跳转页面
    @RequestMapping({"/measure/add"})
    public String add() {
        return "/WEB-INF/jsp/measurement_add.jsp";
    }

    //新增功能
    @ResponseBody
    @RequestMapping("/measure/insert")
    public Data insert(FinalMeasuretCheck finalMeasuretCheck) {
        Data data = finalMeasuretCheckService.insert(finalMeasuretCheck);
        return data;
    }

    //跳转修改页面
    @RequestMapping(value = {"measure/edit"}, method = RequestMethod.GET)
    public String edit() {
        return "/WEB-INF/jsp/measurement_edit.jsp";
    }

    //修改功能
    @ResponseBody
    @RequestMapping("/measure/update_all")
    public Data updateAll(FinalMeasuretCheck finalMeasuretCheck) {
        Data data = finalMeasuretCheckService.updateAll(finalMeasuretCheck);
        return data;
    }

    //修改note功能
    @ResponseBody
    @RequestMapping("/measure/update_note")
    public Data updateOne(FinalMeasuretCheck finalMeasuretCheck) {
        Data data = finalMeasuretCheckService.updateOne(finalMeasuretCheck);
        return data;
    }


    //删除功能
    @ResponseBody
    @RequestMapping(value = "/measure/delete_batch")
    public Data deleteBatch(String[] ids) {
        Data data = finalMeasuretCheckService.deleteBatch(ids);
        return data;
    }

    //    查询-分页
    @ResponseBody
    @RequestMapping("/measure/list")
    public EUDataGridResult selectAll(int page, int rows) {
        EUDataGridResult result = finalMeasuretCheckService.getItemList(page, rows);
        return result;
    }

    //多表查询-右上角按键1
    @ResponseBody
    @RequestMapping("/measure/search_fMeasureCheck_by_fMeasureCheckId")
    public EUDataGridResult selectRightOne(String searchValue,int page, int rows) {
        EUDataGridResult result = finalMeasuretCheckService.getItemList1(searchValue,page, rows);
        return result;
    }
    //多表查询-右上角按键2
    @ResponseBody
    @RequestMapping("/measure/search_fMeasureCheck_by_orderId")
    public EUDataGridResult selectRightTwo(String searchValue, int page, int rows) {
        EUDataGridResult result = finalMeasuretCheckService.getItemList2(searchValue, page, rows);
        return result;
    }

}