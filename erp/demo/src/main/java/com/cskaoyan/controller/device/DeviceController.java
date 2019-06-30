package com.cskaoyan.controller.device;
import com.cskaoyan.bean.device.Device;
import com.cskaoyan.service.device.DeviceService;
import com.cskaoyan.bean.VO.DeviceResponseVo;
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
    public DeviceResponseVo insertDevice(@Valid Device device, BindingResult bindingResult) {
        DeviceResponseVo deviceResponseVo =new DeviceResponseVo();
        int i= deviceService.insert(device);
        deviceResponseVo.setStatus(200);
        deviceResponseVo.setMessage("OK");
        deviceResponseVo.setData(null);
        return deviceResponseVo;}

    @RequestMapping("deviceList/edit_judge")
    @ResponseBody
    public String edit_judge() { return ""; }

    @RequestMapping("deviceList/edit")
    public String edit() {
        return "deviceList_edit";
    }

    @RequestMapping(value = "deviceList/update",produces="application/json;charset=UTF-8")
    @ResponseBody
    public DeviceResponseVo updateDevice(@Valid Device device) {
        DeviceResponseVo deviceResponseVo =new DeviceResponseVo();
        int ret = deviceService.updateByPrimaryKey(device);
        deviceResponseVo.setStatus(200);
        deviceResponseVo.setMessage("OK");
        deviceResponseVo.setData(null);
        return deviceResponseVo;
    }

    @RequestMapping("deviceList/delete_judge")
    @ResponseBody
    public String delete_judge() {
        return "";
    }

    @RequestMapping("deviceList/delete_batch")
    @ResponseBody
    public DeviceResponseVo delete(String[] ids) {
        DeviceResponseVo deviceResponseVo =new DeviceResponseVo();
        int ret = deviceService.deleteByPrimaryKey(ids);
        deviceResponseVo.setStatus(200);
        deviceResponseVo.setMessage("OK");
        deviceResponseVo.setData(null);
        return deviceResponseVo;
    }
}
