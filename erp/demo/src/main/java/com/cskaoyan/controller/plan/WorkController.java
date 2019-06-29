package com.cskaoyan.controller.plan;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.VO.WorkVO;
import com.cskaoyan.bean.plan.Work;
import com.cskaoyan.service.plan.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: TXJ
 * @Date: 2019/6/28 21:14
 * @Version 1.0
 */
@Controller
@RequestMapping("/work")
public class WorkController {
    //增删改查
    @Autowired
    WorkService workService;

    @RequestMapping("/get/{workId}")
    @ResponseBody
    public WorkVO getItemById( String workId) throws Exception{
        WorkVO work = workService.get(workId);
        return work;
    }
    //显示    模块
    @RequestMapping("/find")
    public String show() {
        return "work_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Page workList(Integer page, Integer rows){
        Page page1= workService.findAllWork(page,rows);
        return page1;
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<WorkVO> getData() throws Exception{
        return workService.find();
    }

    @RequestMapping("/add")
    public String add() throws Exception{
        return "work_add";
    }
    @RequestMapping("/add_judge")
    public String addjudge() throws Exception{
        return "work_add";
    }
    @RequestMapping("/edit")
    public String edit() throws Exception{
        return "work_edit";
    }
    @RequestMapping("/edit_judge")
    public String editj() throws Exception{
        return "work_edit";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public QueryStatus insert(Work work){
        return workService.insert(work);
    }
    @RequestMapping("/update")
    @ResponseBody
    public QueryStatus update(Work work){
        return workService.update(work);
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public QueryStatus updateall(Work work){
        return workService.update(work);
    }
    @RequestMapping("/delete_judge")
    @ResponseBody
    public void deletej(){

    }
    @RequestMapping("/delete")
    @ResponseBody
    public QueryStatus delete(String id){
        return workService.delete(id);
    }

    @RequestMapping(value="/delete_batch")
    @ResponseBody
    public QueryStatus deleteBatchwork(String[] ids){
        QueryStatus queryStatus=workService.deleteBatchwork(ids);
        return queryStatus;
    }

    //根据作业id查找
    @RequestMapping("/search_work_by_workId")
    @ResponseBody
    public Page searchWorkByWorkId(Integer page, Integer rows, String searchValue){
        Page page1=workService.searchWorkByWorkId(page,rows,searchValue);
        return page1;
    }

    //根据产品名称查找
    @RequestMapping("/search_work_by_workProduct")
    @ResponseBody
    public Page searchWorkByWorkProduct(Integer page, Integer rows, String searchValue){
        Page page1=workService.searchWorkByWorkProduct(page,rows,searchValue);
        return page1;
    }

    //根据设备id查找
    @RequestMapping("/search_work_by_workDevice")
    @ResponseBody
    public Page searchWorkByWorkDevice(Integer page, Integer rows, String searchValue){
        Page page1=workService.searchWorkByWorkDevice(page,rows,searchValue);
        return page1;
    }

    //根据工序id查找
    @RequestMapping("/search_work_by_workProcess")
    @ResponseBody
    public Page searchWorkByWorkProcess(Integer page, Integer rows, String searchValue){
        Page page1=workService.searchWorkByWorkProcess(page,rows,searchValue);
        return page1;
    }
}
