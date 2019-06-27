package com.cskaoyan.controller;

import com.cskaoyan.bean.Device_Type;
import com.cskaoyan.service.type.Device_TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DeviceTypeContoller {
    @Autowired
    private Device_TypeService device_typeService;

    @RequestMapping("device/deviceType")
    public String entry(){
        return "deviceType";
    }

    @RequestMapping("deviceType/list")
    @ResponseBody
    public List<Device_Type> queryDeviceTypes(int page,int rows){
        List<Device_Type> device_types = device_typeService.selectAll();
        return device_types;
    }


    @RequestMapping("deviceType/add_judge")
    @ResponseBody
    public String add_judge() {
        return "";
    }

    @RequestMapping("deviceType/add")
    public String add() {
        return "deviceType_add";
    }

    @RequestMapping("deviceType/insert")
    @ResponseBody
    public String insertDeviceType(Device_Type deviceType) {
        int ret = device_typeService.insert(deviceType);
        if (ret == 1) {
            return "200";
        } else {
            return "300";
        }
    }

    @RequestMapping("deviceType/edit_judge")
    @ResponseBody
    public String edit_judge() { return ""; }

    @RequestMapping("deviceType/edit")
    public String edit() {
        return "deviceType_edit";
    }
    //更新设备种类
    @RequestMapping("deviceType/update")
    @ResponseBody
    public String updateDeviceType(Device_Type deviceType) {
        int ret = device_typeService.updateByPrimaryKey(deviceType);
        return "200";
    }

    //
    @RequestMapping("deviceType/delete_judge")
    @ResponseBody
    public String delete_judge() {
        return "";
    }
/*
    删除选中的记录
    @RequestMapping("deviceType/delete_batch")
    @ResponseBody
    public String delete(String[] ids) {
        int ret = device_typeService.deleteByPrimaryKey(ids);
        return "200";
    }*/

    /*根据设备种类编号搜索*/
/*    @RequestMapping("deviceType/search_deviceType_by_deviceTypeId")
    @ResponseBody
    public List<Device_Type> queryDeviceTypeById(String searchValue, int page, int rows) {
        Device_Type device_type = device_typeService.selectByPrimaryKey(searchValue);
        return deviceTypes;
    }

    *//*根据设备种类名称搜索*//*
    @RequestMapping("deviceType/search_deviceType_by_deviceTypeName")
    @ResponseBody
    public List<DeviceType> queryDeviceTypeByName(String searchValue, int page, int rows) {
        List<DeviceType> deviceTypes = deviceTypeService.queryDeviceTypeByName(searchValue);
        return deviceTypes;
    }*/


}
