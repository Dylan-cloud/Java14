package cn.az.controller;

import cn.az.bean.Data;
import cn.az.bean.EUDataGridResult;
import cn.az.bean.FinalCountCheck;
import cn.az.service.FinalCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class FinalCountCheckController {

    @Autowired
    FinalCountCheckService finalCountCheckService;

    //处理judge
    @ResponseBody
    @RequestMapping(value = {"/fCountCheck/add_judge", "/fCountCheck/delete_judge", "/fCountCheck/edit_judge"})
    public Data judge() {
        return new Data();
    }

    //find to list
    @RequestMapping("/f_count_check/find")
    public String toList() {
        return "/WEB-INF/jsp/f_count_check_list.jsp";
    }

    //新增跳转页面
    @RequestMapping({"/f_count_check/add"})
    public String add() {
        return "/WEB-INF/jsp/f_count_check_add.jsp";
    }

    //新增功能
    @ResponseBody
    @RequestMapping("/f_count_check/insert")
    public Data insert(FinalCountCheck finalCountCheck) {
        Data data = finalCountCheckService.insert(finalCountCheck);
        return data;
    }

    //跳转修改页面
    @RequestMapping(value = {"f_count_check/edit"}, method = RequestMethod.GET)
    public String edit() {
        return "/WEB-INF/jsp/f_count_check_edit.jsp";
    }

    //修改功能
    @ResponseBody
    @RequestMapping("/f_count_check/update_all")
    public Data updateAll(FinalCountCheck finalCountCheck) {
        Data data = finalCountCheckService.updateAll(finalCountCheck);
        return data;
    }

    //修改note功能
    @ResponseBody
    @RequestMapping("/f_count_check/update_note")
    public Data updateOne(FinalCountCheck finalCountCheck) {
        Data data = finalCountCheckService.updateOne(finalCountCheck);
        return data;
    }


    //删除功能
    @ResponseBody
    @RequestMapping(value = "/f_count_check/delete_batch")
    public Data deleteBatch(String[] ids, Model model) {
        Data data = finalCountCheckService.deleteBatch(ids);
        return data;
    }

    //    查询-分页
    @ResponseBody
    @RequestMapping("/f_count_check/list")
    public EUDataGridResult selectAll(int page, int rows) {
        EUDataGridResult result = finalCountCheckService.getItemList(page, rows);
        return result;
    }

    //多表查询-右上角按键1
    @ResponseBody
    @RequestMapping("/f_count_check/search_fCountCheck_by_fCountCheckId")
    public EUDataGridResult selectRightOne(String searchValue,int page, int rows) {
        EUDataGridResult result = finalCountCheckService.getItemList1(searchValue,page, rows);
        return result;
    }
    //多表查询-右上角按键2
    @ResponseBody
    @RequestMapping("/f_count_check/search_fCountCheck_by_orderId")
    public EUDataGridResult selectRightTwo(String searchValue, int page, int rows) {
        EUDataGridResult result = finalCountCheckService.getItemList2(searchValue, page, rows);
        return result;
    }

}