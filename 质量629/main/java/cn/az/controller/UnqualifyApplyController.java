package cn.az.controller;

import cn.az.bean.Data;
import cn.az.bean.EUDataGridResult;
import cn.az.bean.FinalMeasuretCheck;
import cn.az.bean.UnqualifyApply;
import cn.az.service.FinalMeasuretCheckService;
import cn.az.service.UnqualifyApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UnqualifyApplyController {

    @Autowired
    UnqualifyApplyService unqualifyApplyService;

    //处理judge
    @ResponseBody
    @RequestMapping(value = {"/unqualify/add_judge", "/unqualify/delete_judge", "/unqualify/edit_judge"})
    public Data judge() {
        return new Data();
    }

    //find to list
    @RequestMapping("/unqualify/find")
    public String toList() {
        return "/WEB-INF/jsp/unqualify_list.jsp";
    }

    //新增跳转页面
    @RequestMapping({"/unqualify/add"})
    public String add() {
        return "/WEB-INF/jsp/unqualify_add.jsp";
    }

    //新增功能
    @ResponseBody
    @RequestMapping("/unqualify/insert")
    public Data insert(UnqualifyApply unqualifyApply) {
        Data data = unqualifyApplyService.insert(unqualifyApply);
        return data;
    }

    //跳转修改页面
    @RequestMapping(value = {"unqualify/edit"}, method = RequestMethod.GET)
    public String edit() {
        return "/WEB-INF/jsp/unqualify_edit.jsp";
    }

    //修改功能
    @ResponseBody
    @RequestMapping("/unqualify/update_all")
    public Data updateAll(UnqualifyApply unqualifyApply) {
        Data data = unqualifyApplyService.updateAll(unqualifyApply);
        return data;
    }

    //修改note功能
    @ResponseBody
    @RequestMapping("/unqualify/update_note")
    public Data updateOne(UnqualifyApply unqualifyApply) {
        Data data = unqualifyApplyService.updateOne(unqualifyApply);
        return data;
    }


    //删除功能
    @ResponseBody
    @RequestMapping(value = "/unqualify/delete_batch")
    public Data deleteBatch(String[] ids) {
        Data data = unqualifyApplyService.deleteBatch(ids);
        return data;
    }

    //    查询-分页
    @ResponseBody
    @RequestMapping("/unqualify/list")
    public EUDataGridResult selectAll(int page, int rows) {
        EUDataGridResult result = unqualifyApplyService.getItemList(page, rows);
        return result;
    }
//    unqualify/search_unqualify_by_unqualifyId?searchValue=02&page=1&rows=10 HTTP/1.1
    //多表查询-右上角按键1
    @ResponseBody
    @RequestMapping("/unqualify/search_unqualify_by_unqualifyId")
    public EUDataGridResult selectRightOne(String searchValue,int page, int rows) {
        EUDataGridResult result = unqualifyApplyService.getItemList1(searchValue,page, rows);
        return result;
    }
//    unqualify/search_unqualify_by_productName?searchValue=02&page=1&rows=10 HTTP/1.1
    //多表查询-右上角按键2
    @ResponseBody
    @RequestMapping("/unqualify/search_unqualify_by_productName")
    public EUDataGridResult selectRightTwo(String searchValue, int page, int rows) {
        EUDataGridResult result = unqualifyApplyService.getItemList2(searchValue, page, rows);
        return result;
    }

}