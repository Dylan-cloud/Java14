package com.cskaoyan.controller;

import com.cskaoyan.bean.Device_Maintain;
import com.cskaoyan.service.maintain.Device_MaintainService;
import com.cskaoyan.vo.ResponseVo;
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
    public ResponseVo insertDeviceMaintain(@Valid Device_Maintain device_maintain, BindingResult bindingResult) {
        ResponseVo responseVo=new ResponseVo();
        int i= device_maintainService.insert(device_maintain);
        responseVo.setStatus(200);
        responseVo.setMessage("OK");
        responseVo.setData(null);
        return responseVo;}

    @RequestMapping("deviceMaintain/edit_judge")
    @ResponseBody
    public String edit_judge() { return ""; }

    @RequestMapping("deviceMaintain/edit")
    public String edit() {
        return "deviceMaintain_edit";
    }

    @RequestMapping(value = "deviceMaintain/update",produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseVo updateDevice(@Valid Device_Maintain device_maintain) {
        ResponseVo responseVo=new ResponseVo();
        int ret = device_maintainService.updateByPrimaryKeySelective(device_maintain);
        responseVo.setStatus(200);
        responseVo.setMessage("OK");
        responseVo.setData(null);
        return responseVo;
    }

    @RequestMapping("deviceMaintain/delete_judge")
    @ResponseBody
    public String delete_judge() {
        return "";
    }

    @RequestMapping("deviceMaintain/delete_batch")
    @ResponseBody
    public ResponseVo delete(String[] ids) {
        ResponseVo responseVo=new ResponseVo();
        int ret = device_maintainService.deleteByPrimaryKey(ids);
        responseVo.setStatus(200);
        responseVo.setMessage("OK");
        responseVo.setData(null);
        return responseVo;
    }
}
