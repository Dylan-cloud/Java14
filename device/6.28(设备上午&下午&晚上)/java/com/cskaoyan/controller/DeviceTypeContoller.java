package com.cskaoyan.controller;

import com.cskaoyan.bean.Device_Type;
import com.cskaoyan.service.type.Device_TypeService;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class DeviceTypeContoller {
    @InitBinder
    public void init(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
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
    @RequestMapping("deviceType/get/{id}")
    @ResponseBody
    public Device_Type queryDeviceTypes(@PathVariable("id")String id){
        Device_Type device_type = device_typeService.selectByPrimaryKey(id);
        return device_type;
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

    @RequestMapping(value = "deviceType/insert",produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseVo insertDeviceType(@Valid Device_Type deviceType, BindingResult bindingResult) {
        ResponseVo responseVo=new ResponseVo();
 /*       if (bindingResult.hasErrors()){
            responseVo.setErrorNo(1);
            FieldError fieldError=bindingResult.getFieldError();
            String field = fieldError.getField();
            String defaultMessage = fieldError.getDefaultMessage();
            responseVo.setMessage(defaultMessage);
            return responseVo;
        }*/
       int i= device_typeService.insert(deviceType);
        responseVo.setStatus(200);
        responseVo.setMessage("OK");
        responseVo.setData(null);
        return responseVo;
    }

    @RequestMapping("deviceType/edit_judge")
    @ResponseBody
    public String edit_judge() { return ""; }

    @RequestMapping("deviceType/edit")
    public String edit() {
        return "deviceType_edit";
    }

    //更新设备种类

    @RequestMapping(value = "deviceType/update",produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseVo updateDeviceType(@Valid Device_Type deviceType) {
        ResponseVo responseVo=new ResponseVo();
        int ret = device_typeService.updateByPrimaryKey(deviceType);
        responseVo.setStatus(200);
        responseVo.setMessage("OK");
        responseVo.setData(null);
        return responseVo;
    }

    //
    @RequestMapping("deviceType/delete_judge")
    @ResponseBody
    public String delete_judge() {
        return "";
    }


    /*    删除选中的记录*/
    @RequestMapping("deviceType/delete_batch")
    @ResponseBody
    public String delete(String[] ids) {
        int ret = device_typeService.deleteByPrimaryKey(ids);
        return "200";
    }


    @RequestMapping("deviceType/get_data")
    @ResponseBody
    public List<Device_Type> getDeviceTypes(){
        List<Device_Type> device_types = device_typeService.selectIdAndName();
        return device_types;
    }
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
