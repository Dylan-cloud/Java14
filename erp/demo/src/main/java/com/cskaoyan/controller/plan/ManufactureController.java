package com.cskaoyan.controller.plan;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.VO.ManufactureVO;
import com.cskaoyan.bean.plan.Manufacture;
import com.cskaoyan.service.plan.ManuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: TXJ
 * @Date: 2019/6/29 19:42
 * @Version 1.0
 */
@Controller
@RequestMapping("/manufacture")
public class ManufactureController {
    @Autowired
    ManuService manuService;

    @RequestMapping("/get/{manufactureId}")
    @ResponseBody
    public ManufactureVO getItemById(String manuId){
        ManufactureVO manufactureVO=manuService.get(manuId);
        return manufactureVO;
    }

    @RequestMapping("/find")
    public String show() {
        return "manufacture_list";
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<ManufactureVO> getdata(){
        return manuService.find();
    }

    @RequestMapping("/list")
    @ResponseBody
    public Page workList(Integer page, Integer rows){
        Page page1= manuService.findAllManu(page,rows);
        return page1;
    }
    @RequestMapping("/add")
    public String add() throws Exception{
        return "manufacture_add";
    }
    @RequestMapping("/add_judge")
    public String addjudge() throws Exception{
        return "manufacture_add";
    }
    @RequestMapping("/edit")
    public String edit() throws Exception{
        return "manufacture_edit";
    }
    @RequestMapping("/edit_judge")
    public String editj() throws Exception{
        return "manufacture_edit";
    }
    @RequestMapping("/delete_judge")
    @ResponseBody
    public void deletej(){

    }
    @RequestMapping("/insert")
    @ResponseBody
    public QueryStatus insert(Manufacture work){
        return manuService.insert(work);
    }
    @RequestMapping("/update")
    @ResponseBody
    public QueryStatus update(Manufacture work){
        return manuService.update(work);
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public QueryStatus updateall(Manufacture work){
        return manuService.update(work);
    }
    @RequestMapping("/delete")
    @ResponseBody
    public QueryStatus delete(String id){
        return manuService.delete(id);
    }

    @RequestMapping(value="/delete_batch")
    @ResponseBody
    public QueryStatus deleteBatchwork(String[] ids){
        QueryStatus queryStatus=manuService.deleteBatchwork(ids);
        return queryStatus;
    }
    //根据生产流水号查找
    @RequestMapping("/search_manufacture_by_manufactureSn")
    @ResponseBody
    public Page searchManufactureByManufactureSn(Integer page, Integer rows, String searchValue){
        Page page1=manuService.searchManufactureByManufactureSn(page,rows,searchValue);
        return page1;
    }

    //根据订单id查找
    @RequestMapping("/search_manufacture_by_manufactureOrderId")
    @ResponseBody
    public Page searchManufactureBymanufactureOrderId(Integer page, Integer rows, String searchValue){
        Page page1=manuService.searchManufactureBymanufactureOrderId(page,rows,searchValue);
        return page1;
    }

    //根据工艺名称查找
    @RequestMapping("/search_manufacture_by_manufactureTechnologyName")
    @ResponseBody
    public Page searchManufactureBymanufactureTechnologyName(Integer page, Integer rows, String searchValue){
        Page page1=manuService.searchManufactureBymanufactureTechnologyName(page,rows,searchValue);
        return page1;
    }
}
