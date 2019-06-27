package com.cskaoyan.controller;



import com.cskaoyan.bean.Device;
import com.cskaoyan.bean.Device_Type;
import com.cskaoyan.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DeviceController {
    @Autowired
    DeviceService deviceService;
    @Autowired
    DataSource dataSource;

    @RequestMapping("device/deviceList")
    public String entry(){
        return "deviceList";
    }

    @RequestMapping("deviceList/list")
    @ResponseBody
    public List<Device> queryDeviceTypes(int page, int rows){
        List<Device> devices = deviceService.selectAll();
        return devices;
    }


}
