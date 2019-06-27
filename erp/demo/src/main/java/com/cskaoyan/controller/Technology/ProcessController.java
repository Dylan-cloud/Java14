package com.cskaoyan.controller.Technology;

import com.cskaoyan.bean.Technology.Process;
import com.cskaoyan.service.Impl.Technology.ProcessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("process")
public class ProcessController {

    @Autowired
    ProcessServiceImpl processService;

    /**
     * 增加单个
     * @param process
     */
    @RequestMapping(value = {"add","insert","add_judge"})
    public void insert(Process process){
        int insert = processService.insert(process);
        System.out.println("insert = " + insert);
    }

    /**
     * 编辑单个
     * @param process
     */
    @RequestMapping(value = {"edit_judge","edit"})
    public void updateByPrimaryKey(Process process){
        int i = processService.updateByPrimaryKey(process);
        System.out.println("i = " + i);
    }

    /**
     * 查询所有
     * @return
     */
    @RequestMapping("list")
    public List<Process> selectAll(){
        List<Process> processes = processService.selectAll();
        return processes;
    }

    /**
     * 删除单个
     * @param processId
     */
    @RequestMapping(value = {"delete_judge"})
    public void deleteByPrimaryKey(String processId){
        int i = processService.deleteByPrimaryKey(processId);
        System.out.println("i = " + i);
    }

}
