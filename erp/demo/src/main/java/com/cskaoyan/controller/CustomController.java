package com.cskaoyan.controller;

import com.cskaoyan.bean.Custom;
import com.cskaoyan.bean.Page;
import com.cskaoyan.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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

    @RequestMapping("/find")
    public String find() {
        return "custom_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Page getItemList(Integer page,Integer rows,Custom custom)throws Exception{
        Page page1=customService.getList(page,rows,custom);
        return page1;
    }

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
    public int insert(Custom custom) throws Exception {
        int i=customService.insert(custom);

        return i;
    }
    //删除模块
    @RequestMapping("/delete_judge")
    @ResponseBody
    public void delete1() throws Exception {
    }
    @RequestMapping("/delete_batch")
    @ResponseBody
    public int deleteBatch(String[] ids){
        try {
            return customService.deleteBatch(ids);
        } catch (Exception e) {
            return -1;
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
    public int edit(Custom custom) throws Exception {
        int i=customService.update(custom);
        return i;
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
