package com.cskaoyan.controller;
import com.cskaoyan.bean.Device;
import com.cskaoyan.bean.Device_Type;
import com.cskaoyan.service.DeviceService;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.sql.DataSource;
import javax.validation.Valid;
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
    public List<Device> queryDevice(int page, int rows){
        List<Device> devices = deviceService.selectAll();
        return devices;
    }

    @RequestMapping("deviceList/get_data")
    @ResponseBody
    public List<Device> getDevice(){
        List<Device> devices = deviceService.selectAll();
        return devices;
    }


    @RequestMapping("deviceList/get/{id}")
    @ResponseBody
    public Device queryDeviceTypes(@PathVariable("id")String id){
        Device devices = deviceService.selectByPrimaryKey(id);
        return devices;
    }

    @RequestMapping("deviceList/add_judge")
    @ResponseBody
    public String add_judge() {
        return "";
    }

    @RequestMapping("deviceList/add")
    public String add() {
        return "deviceList_add";
    }

    @RequestMapping(value = "deviceList/insert",produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseVo insertDevice(@Valid Device device, BindingResult bindingResult) {
        ResponseVo responseVo=new ResponseVo();
        int i= deviceService.insert(device);
        responseVo.setStatus(200);
        responseVo.setMessage("OK");
        responseVo.setData(null);
        return responseVo;}

    @RequestMapping("deviceList/edit_judge")
    @ResponseBody
    public String edit_judge() { return ""; }

    @RequestMapping("deviceList/edit")
    public String edit() {
        return "deviceList_edit";
    }

    @RequestMapping(value = "deviceList/update",produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseVo updateDevice(@Valid Device device) {
        ResponseVo responseVo=new ResponseVo();
        int ret = deviceService.updateByPrimaryKey(device);
        responseVo.setStatus(200);
        responseVo.setMessage("OK");
        responseVo.setData(null);
        return responseVo;
    }

    @RequestMapping("deviceList/delete_judge")
    @ResponseBody
    public String delete_judge() {
        return "";
    }

    @RequestMapping("deviceList/delete_batch")
    @ResponseBody
    public ResponseVo delete(String[] ids) {
        ResponseVo responseVo=new ResponseVo();
        int ret = deviceService.deleteByPrimaryKey(ids);
        responseVo.setStatus(200);
        responseVo.setMessage("OK");
        responseVo.setData(null);
        return responseVo;
    }
}
