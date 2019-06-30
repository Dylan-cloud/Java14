package com.cskaoyan.controller.device;

import com.cskaoyan.bean.device.Device_Fault;
import com.cskaoyan.service.device.fault.Device_FaultService;
import com.cskaoyan.bean.VO.DeviceResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class DeviceFaultController {
    @InitBinder
    public void init(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
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
    @RequestMapping("deviceFault/get_data")
    @ResponseBody
    public List<Device_Fault> getDeviceFault(){
        List<Device_Fault> device_faults = device_faultService.selectIdAndName();
        return device_faults;
    }


    @RequestMapping("deviceFault/add_judge")
    @ResponseBody
    public String add_judge() {
        return "";
    }

    @RequestMapping("deviceFault/add")
    public String add() {
        return "deviceFault_add";
    }


    @RequestMapping(value = "deviceFault/insert",produces="application/json;charset=UTF-8")
    @ResponseBody
    public DeviceResponseVo insertDeviceMaintain(@Valid Device_Fault device_fault, BindingResult bindingResult) {
        DeviceResponseVo deviceResponseVo =new DeviceResponseVo();
        int i= device_faultService.insert(device_fault);
        deviceResponseVo.setStatus(200);
        deviceResponseVo.setMessage("OK");
        deviceResponseVo.setData(null);
        return deviceResponseVo;}

    @RequestMapping("deviceFault/edit_judge")
    @ResponseBody
    public String edit_judge() { return ""; }

    @RequestMapping("deviceFault/edit")
    public String edit() {
        return "deviceFault_edit";
    }

    @RequestMapping(value = "deviceFault/update",produces="application/json;charset=UTF-8")
    @ResponseBody
    public DeviceResponseVo updateDevice(@Valid Device_Fault device_fault) {
        DeviceResponseVo deviceResponseVo =new DeviceResponseVo();
        int ret = device_faultService.updateByPrimaryKeySelective(device_fault);
        deviceResponseVo.setStatus(200);
        deviceResponseVo.setMessage("OK");
        deviceResponseVo.setData(null);
        return deviceResponseVo;
    }

    @RequestMapping("deviceFault/delete_judge")
    @ResponseBody
    public String delete_judge() {
        return "";
    }

    @RequestMapping("deviceFault/delete_batch")
    @ResponseBody
    public DeviceResponseVo delete(String[] ids) {
        DeviceResponseVo deviceResponseVo =new DeviceResponseVo();
        int ret = device_faultService.deleteByPrimaryKey(ids);
        deviceResponseVo.setStatus(200);
        deviceResponseVo.setMessage("OK");
        deviceResponseVo.setData(null);
        return deviceResponseVo;
    }




}
