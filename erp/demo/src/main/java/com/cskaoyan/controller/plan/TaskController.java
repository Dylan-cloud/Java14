package com.cskaoyan.controller.plan;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.plan.Task;
import com.cskaoyan.service.plan.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: TXJ
 * @Date: 2019/6/29 21:19
 * @Version 1.0
 */
@RequestMapping("/task")
@Controller
public class TaskController {
    @Autowired
    TaskService taskService;

    @RequestMapping("/get/{empId}")
    @ResponseBody
    public Task getItemById(String empId){
        Task task=taskService.get(empId);
        return task;
    }
    @RequestMapping("/list")
    @ResponseBody
    public Page workList(Integer page, Integer rows){
        Page page1= taskService.findAllTask(page,rows);
        return page1;
    }
    @RequestMapping("/get_data")
    @ResponseBody
    public List<Task> getData() throws Exception{
        return taskService.find();
    }

    @RequestMapping("/find")
    public String find() throws Exception{
        return "task_list";
    }
    @RequestMapping("/add")
    public String add() throws Exception{
        return "task_add";
    }
    @RequestMapping("/add_judge")
    public String addjudge() throws Exception{
        return "task_add";
    }
    @RequestMapping("/edit")
    public String edit() throws Exception{
        return "task_edit";
    }
    @RequestMapping("/edit_judge")
    public String editj() throws Exception{
        return "task_edit";
    }
    @RequestMapping("/delete_judge")
    @ResponseBody
    public void deletej(){

    }
    @RequestMapping("/insert")
    @ResponseBody
    public QueryStatus insert(Task work){
        return taskService.insert(work);
    }
    @RequestMapping("/update")
    @ResponseBody
    public QueryStatus update(Task work){
        return taskService.update(work);
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public QueryStatus updateall(Task work){
        return taskService.update(work);
    }
    @RequestMapping("/delete")
    @ResponseBody
    public QueryStatus delete(String id){
        return taskService.delete(id);
    }

    @RequestMapping(value="/delete_batch")
    @ResponseBody
    public QueryStatus deleteBatchwork(String[] ids){
        QueryStatus queryStatus=taskService.deleteBatchwork(ids);
        return queryStatus;
    }
//根据生产派工id查找
    @RequestMapping("/search_task_by_taskId")
    @ResponseBody
    public Page searchtaskBytaskId(Integer page, Integer rows, String searchValue){
        Page page1=taskService.searchtaskBytaskId(page,rows,searchValue);
        return page1;
    }

    //根据作业id查找
    @RequestMapping("/search_task_by_taskWorkId")
    @ResponseBody
    public Page searchtaskBytaskWorkId(Integer page, Integer rows, String searchValue){
        Page page1=taskService.searchtaskBytaskWorkId(page,rows,searchValue);
        return page1;
    }

    //根据生产计划id查找
    @RequestMapping("/search_task_by_taskManufactureSn")
    @ResponseBody
    public Page searchtaskBytaskManufactureSn(Integer page, Integer rows, String searchValue){
        Page page1=taskService.searchtaskManufactureSn(page,rows,searchValue);
        return page1;
    }
}
