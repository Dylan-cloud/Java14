package com.cskaoyan.controller.device;

import com.cskaoyan.bean.device.Device_Maintain;
import com.cskaoyan.service.device.maintain.Device_MaintainService;
import com.cskaoyan.bean.VO.DeviceResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class DeviceMaintainController {
    @InitBinder
    public void init(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
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

    @RequestMapping("deviceMaintain/add_judge")
    @ResponseBody
    public String add_judge() {
        return "";
    }

    @RequestMapping("deviceMaintain/add")
    public String add() {
        return "deviceMaintain_add";
    }


    @RequestMapping(value = "deviceMaintain/insert",produces="application/json;charset=UTF-8")
    @ResponseBody
    public DeviceResponseVo insertDeviceMaintain(@Valid Device_Maintain device_maintain, BindingResult bindingResult) {
        DeviceResponseVo deviceResponseVo =new DeviceResponseVo();
        int i= device_maintainService.insert(device_maintain);
        deviceResponseVo.setStatus(200);
        deviceResponseVo.setMessage("OK");
        deviceResponseVo.setData(null);
        return deviceResponseVo;}

    @RequestMapping("deviceMaintain/edit_judge")
    @ResponseBody
    public String edit_judge() { return ""; }

    @RequestMapping("deviceMaintain/edit")
    public String edit() {
        return "deviceMaintain_edit";
    }

    @RequestMapping(value = "deviceMaintain/update",produces="application/json;charset=UTF-8")
    @ResponseBody
    public DeviceResponseVo updateDevice(@Valid Device_Maintain device_maintain) {
        DeviceResponseVo deviceResponseVo =new DeviceResponseVo();
        int ret = device_maintainService.updateByPrimaryKeySelective(device_maintain);
        deviceResponseVo.setStatus(200);
        deviceResponseVo.setMessage("OK");
        deviceResponseVo.setData(null);
        return deviceResponseVo;
    }

    @RequestMapping("deviceMaintain/delete_judge")
    @ResponseBody
    public String delete_judge() {
        return "";
    }

    @RequestMapping("deviceMaintain/delete_batch")
    @ResponseBody
    public DeviceResponseVo delete(String[] ids) {
        DeviceResponseVo deviceResponseVo =new DeviceResponseVo();
        int ret = device_maintainService.deleteByPrimaryKey(ids);
        deviceResponseVo.setStatus(200);
        deviceResponseVo.setMessage("OK");
        deviceResponseVo.setData(null);
        return deviceResponseVo;
    }
}
