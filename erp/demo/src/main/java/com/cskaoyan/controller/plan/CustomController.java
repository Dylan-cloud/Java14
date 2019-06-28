package com.cskaoyan.controller.plan;

import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.plan.Custom;
import com.cskaoyan.bean.Page;
import com.cskaoyan.service.plan.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: TXJ
 * @Date: 2019/6/26 23:14
 * @Version 1.0
 */
@Controller
@RequestMapping("/custom")
public class CustomController {
    @Autowired
    CustomService customService;
    //跳转到custom_list的过程中就会带有请求list的动作
    @RequestMapping("/find")
    public String find() {
        return "custom_list";
    }

    //带有分页的返回，要自己写一个分页对象，该对象包括总数和一个list
    @RequestMapping("/list")
    @ResponseBody
    public Page getItemList(Integer page,Integer rows,Custom custom)throws Exception{
        Page page1=customService.getList(page,rows,custom);
        return page1;
    }//显示数据

    @RequestMapping("/get_data")
    @ResponseBody
    public List<Custom> list() throws Exception {
        List <Custom> list=customService.find();
        return list;
    }

    //增加模块
    @RequestMapping("/add_judge")
    public String add(){
        return "custom_add";
    }
    @RequestMapping("/add")
    public String add2(){
        return "custom_add";
    }
   @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ResponseBody
    public QueryStatus insert(Custom custom) throws Exception {
        return customService.insert(custom);

    }
    //删除模块
    @RequestMapping("/delete_judge")
    @ResponseBody
    public void delete1() throws Exception {
    }
    @RequestMapping("/delete_batch")
    @ResponseBody
    public QueryStatus deleteBatch(String[] ids){
        try {
            return customService.deleteBatch(ids);
        } catch (Exception e) {
            QueryStatus queryStatus = new QueryStatus();
            queryStatus.setStatus(0);
            queryStatus.setMsg(e.getMessage());
            return queryStatus;
        }
    }
    //修改模块
    @RequestMapping("/edit_judge")
    public String edit1(){
        return "custom_edit";
    }
    @RequestMapping("/edit")
    public String edit2(){
        return "custom_edit";
    }
    @RequestMapping("/update_all")
    @ResponseBody
    public QueryStatus edit(Custom custom) {
       return customService.update(custom);
    }
    @RequestMapping("/update_note")
    @ResponseBody
    public QueryStatus updatenote(Custom custom){
        return customService.updatenote(custom);
    }
    //查询模块
    @RequestMapping("/search_custom_by_customId")
    @ResponseBody
    public Page searchCustomById(String searchValue,int page,int rows){
        return customService.searchCustomById(searchValue,page,rows);
    }
    @RequestMapping("/search_custom_by_customName")
    @ResponseBody
    public Page searchCustomByName(String searchValue,int page,int rows){
        return customService.searchCustomByName(searchValue,page,rows);
    }
}
