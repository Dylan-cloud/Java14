package com.cskaoyan.controller;
import com.cskaoyan.bean.Device;
import com.cskaoyan.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.sql.DataSource;
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

    @RequestMapping("deviceList/get/{id}")
    @ResponseBody
    public Device queryDeviceTypes(@PathVariable("id")String id){
        Device devices = deviceService.selectByPrimaryKey(id);
        return devices;
    }
}
