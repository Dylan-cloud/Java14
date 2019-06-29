package cn.az.controller;

import cn.az.bean.Data;
import cn.az.bean.EUDataGridResult;
import cn.az.bean.FinalCountCheck;
import cn.az.bean.ProcessCountCheck;
import cn.az.service.FinalCountCheckService;
import cn.az.service.ProcessCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ProcessCountCheckController {

    @Autowired
    ProcessCountCheckService processCountCheckService;

    //处理judge
    @ResponseBody
    @RequestMapping(value = {"/pCountCheck/add_judge", "/pCountCheck/delete_judge", "/pCountCheck/edit_judge"})
    public Data judge() {
        return new Data();
    }

    //find to list
    @RequestMapping("/p_count_check/find")
    public String toList() {
        return "/WEB-INF/jsp/p_count_check_list.jsp";
    }

    //新增跳转页面
    @RequestMapping({"/p_count_check/add"})
    public String add() {
        return "/WEB-INF/jsp/p_count_check_add.jsp";
    }

    //新增功能
    @ResponseBody
    @RequestMapping("/p_count_check/insert")
    public Data insert(ProcessCountCheck processCountCheck) {
        Data data = processCountCheckService.insert(processCountCheck);
        return data;
    }

    //跳转修改页面
    @RequestMapping(value = {"p_count_check/edit"}, method = RequestMethod.GET)
    public String edit() {
        return "/WEB-INF/jsp/p_count_check_edit.jsp";
    }

    //修改功能
    @ResponseBody
    @RequestMapping("/p_count_check/update_all")
    public Data updateAll(ProcessCountCheck processCountCheck) {
        Data data = processCountCheckService.updateAll(processCountCheck);
        return data;
    }

    //修改note功能
    @ResponseBody
    @RequestMapping("/p_count_check/update_note")
    public Data updateOne(ProcessCountCheck processCountCheck) {
        Data data = processCountCheckService.updateOne(processCountCheck);
        return data;
    }


    //删除功能
    @ResponseBody
    @RequestMapping(value = "/p_count_check/delete_batch")
    public Data deleteBatch(String[] ids, Model model) {
        Data data = processCountCheckService.deleteBatch(ids);
        return data;
    }

    //    查询-分页
    @ResponseBody
    @RequestMapping("/p_count_check/list")
    public EUDataGridResult selectAll(int page, int rows) {
        EUDataGridResult result = processCountCheckService.getItemList(page, rows);
        return result;
    }

//  p_count_check/search_pCountCheck_by_pCountCheckId?searchValue=12&page=1&rows=10 HTTP/1.1
    //多表查询-右上角按键1
    @ResponseBody
    @RequestMapping("/p_count_check/search_pCountCheck_by_pCountCheckId")
    public EUDataGridResult selectRightOne(String searchValue,int page, int rows) {
        EUDataGridResult result = processCountCheckService.getItemList1(searchValue,page, rows);
        return result;
    }
    /*//多表查询-右上角按键2
    @ResponseBody
    @RequestMapping("/f_count_check/search_fCountCheck_by_orderId")
    public EUDataGridResult selectRightTwo(String searchValue, int page, int rows) {
        EUDataGridResult result = finalCountCheckService.getItemList2(searchValue, page, rows);
        return result;
    }*/

}