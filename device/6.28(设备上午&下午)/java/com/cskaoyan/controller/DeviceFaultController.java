package com.cskaoyan.controller;

import com.cskaoyan.bean.Device_Fault;
import com.cskaoyan.service.fault.Device_FaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.util.List;

@Controller
public class DeviceFaultController {
    @Autowired
    Device_FaultService device_faultService;
    @Autowired
    DataSource dataSource;

    @RequestMapping("device/deviceFault")
    public String entry(){
        return "deviceFault";
    }

    @RequestMapping("deviceFault/list")
    @ResponseBody
    public List<Device_Fault> queryDeviceTypes(int page, int rows){
        return device_faultService.selectAll();
    }


    @RequestMapping("deviceFault/get/{id}")
    @ResponseBody
    public Device_Fault queryDeviceTypes(@PathVariable("id")String id){
        Device_Fault devices = device_faultService.selectByPrimaryKey(id);
        return devices;
    }
}
