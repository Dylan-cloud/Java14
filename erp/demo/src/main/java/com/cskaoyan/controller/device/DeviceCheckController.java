package com.cskaoyan.controller.device;

import com.cskaoyan.bean.device.Device_Check;
import com.cskaoyan.service.device.check.Device_CheckService;
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
public class DeviceCheckController {
    @InitBinder
    public void init(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
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



    @RequestMapping("deviceCheck/add_judge")
    @ResponseBody
    public String add_judge() {
        return "";
    }

    @RequestMapping("deviceCheck/add")
    public String add() {
        return "deviceCheck_add";
    }

    @RequestMapping(value = "deviceCheck/insert",produces="application/json;charset=UTF-8")
    @ResponseBody
    public DeviceResponseVo insertDevice(@Valid Device_Check device_check, BindingResult bindingResult) {
        DeviceResponseVo deviceResponseVo =new DeviceResponseVo();
        int i= device_checkService.insert(device_check);
        deviceResponseVo.setStatus(200);
        deviceResponseVo.setMessage("OK");
        deviceResponseVo.setData(null);
        return deviceResponseVo;}

    @RequestMapping("deviceCheck/edit_judge")
    @ResponseBody
    public String edit_judge() { return ""; }

    @RequestMapping("deviceCheck/edit")
    public String edit() {
        return "deviceCheck_edit";
    }

    @RequestMapping(value = "deviceCheck/update",produces="application/json;charset=UTF-8")
    @ResponseBody
    public DeviceResponseVo updateDeviceCheck(@Valid Device_Check device) {
        DeviceResponseVo deviceResponseVo =new DeviceResponseVo();
        int ret = device_checkService.updateByPrimaryKeySelective(device);
        deviceResponseVo.setStatus(200);
        deviceResponseVo.setMessage("OK");
        deviceResponseVo.setData(null);
        return deviceResponseVo;
    }

    @RequestMapping("deviceCheck/delete_judge")
    @ResponseBody
    public String delete_judge() {
        return "";
    }

    @RequestMapping("deviceCheck/delete_batch")
    @ResponseBody
    public DeviceResponseVo delete(String[] ids) {
        DeviceResponseVo deviceResponseVo =new DeviceResponseVo();
        int ret = device_checkService.deleteByPrimaryKey(ids);
        deviceResponseVo.setStatus(200);
        deviceResponseVo.setMessage("OK");
        deviceResponseVo.setData(null);
        return deviceResponseVo;
    }
}
