package com.cskaoyan.controller;

import com.cskaoyan.bean.Device_Maintain;
import com.cskaoyan.service.maintain.Device_MaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.util.List;

@Controller
public class DeviceMaintainController {
    @Autowired
    Device_MaintainService device_maintainService;
    @Autowired
    DataSource dataSource;

    @RequestMapping("device/deviceMaintain")
    public String entry(){
        return "deviceMaintain";
    }

    @RequestMapping("deviceMaintain/list")
    @ResponseBody
    public List<Device_Maintain> queryDeviceTypes(int page, int rows){
        return device_maintainService.selectAll();
    }

}
