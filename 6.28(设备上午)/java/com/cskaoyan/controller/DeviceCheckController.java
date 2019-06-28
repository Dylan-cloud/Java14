package com.cskaoyan.controller;

import com.cskaoyan.bean.Device;
import com.cskaoyan.bean.Device_Check;
import com.cskaoyan.service.DeviceService;
import com.cskaoyan.service.check.Device_CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.util.List;

@Controller
public class DeviceCheckController {
    @Autowired
    Device_CheckService device_checkService;
    @Autowired
    DataSource dataSource;

    @RequestMapping("device/deviceCheck")
    public String entry(){
        return "deviceCheck";
    }

    @RequestMapping("deviceCheck/list")
    @ResponseBody
    public List<Device_Check> queryDeviceTypes(int page, int rows){
        return device_checkService.selectAll();
    }
}
