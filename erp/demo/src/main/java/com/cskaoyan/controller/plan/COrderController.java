package com.cskaoyan.controller.plan;

import com.cskaoyan.bean.Data;
import com.cskaoyan.bean.Page;

import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.VO.COrderVO;
import com.cskaoyan.bean.plan.COrder;
import com.cskaoyan.service.plan.COrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * @Author: TXJ
 * @Date: 2019/6/28 16:32
 * @Version 1.0
 */
@Controller
public class COrderController {
    @Autowired
    COrderService cOrderService;

    //订单展示
    @RequestMapping("/order/list")
    @ResponseBody
    public Page order(int page, int rows) {
        return cOrderService.findOrder(page, rows);
    }

    @RequestMapping("/order/get_data")
    @ResponseBody
    public List<COrderVO> find(){
        return cOrderService.find();
    }

    @RequestMapping("/order/find")
    public String orderList() {
        return "order_list";
    }

    //增加
    @RequestMapping("/order/add_judge")
    public String orderAddJudge() {
        return "order_add";
    }

    @RequestMapping("/order/add")
    public String orderAdd() {
        return "order_add";
    }

    @RequestMapping("/order/insert")
    @ResponseBody
    public QueryStatus orderInsert(COrder cOrder) {
        return cOrderService.insert(cOrder);
    }

    @RequestMapping("/file/upload")
    @ResponseBody
    public QueryStatus uploadFile(MultipartFile file, HttpServletRequest req) throws IOException {
        String fileName = file.getOriginalFilename();
        String contextPath = req.getContextPath();
        //将文件夹打散
        int i = fileName.hashCode();
        String hexString = Integer.toHexString(i);
        char[] chars = hexString.toCharArray();
        fileName = chars[0] + "/" + chars[1] + "/" + fileName;
        String path = req.getSession().getServletContext().getRealPath("/WEB-INF/file/");
        File file1 = new File(path + fileName);
        if (!file1.exists()) {
            file1.mkdirs();
        }
        file.transferTo(file1);
        QueryStatus queryStatus = new QueryStatus();
        queryStatus.setError(0);
        queryStatus.setUrl(contextPath + "/file/" + fileName);
        return queryStatus;
    }

    @RequestMapping("/file/download")
    @ResponseBody
    public QueryStatus download(String fileName, HttpServletRequest request, HttpServletResponse response) {
        String contextPath = request.getContextPath();
        String path = request.getSession().getServletContext().getRealPath("/");

        //String replace=fileName.replace(
        int index = fileName.lastIndexOf("/");
        String downloadFile = fileName.substring(index + 1);
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + downloadFile);

        try (InputStream inputStream = new FileInputStream(path + "/WEB-INF" + fileName);
             ServletOutputStream outputStream = response.getOutputStream()) {
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                outputStream.write(b, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new QueryStatus();
    }

    @RequestMapping("file/delete")
    @ResponseBody
    public Data picDelete(String fileName, HttpServletRequest request) {
        String path = request.getSession().getServletContext().getRealPath("/WEB-INF/image/upload/");
        fileName = fileName.substring(fileName.lastIndexOf("/") + 1);
        File file = new File(path + fileName);
        if (file.exists()) {
            file.delete();
        }
        Data data = new Data();
        data.setData("success");
        return data;
    }

    @RequestMapping("/order/edit_judge")
    public String editJudge() {
        return "order_edit";
    }

    @RequestMapping("/order/edit")
    public String edit() {
        return "order_edit";
    }

    @RequestMapping("/order/update_all")
    @ResponseBody
    public QueryStatus updateAll(COrder cOrder) {
        return cOrderService.updateByPrimaryKeySelective(cOrder);
    }

    @RequestMapping("/order/update_note")
    @ResponseBody
    public QueryStatus updateNote(COrder cOrder) {

        return cOrderService.updateNote(cOrder);
    }

    @RequestMapping("/order/search_order_by_orderId")
    @ResponseBody
    public Page searchOrderById(String searchValue, int page, int rows) {
        return cOrderService.searchProductById(searchValue, page, rows);
    }

    @RequestMapping("/order/search_order_by_orderCustom")
    @ResponseBody
    public Page searchOrderByCustom(String searchValue, int page, int rows) {
        return cOrderService.searchOrderByCustom(searchValue, page, rows);
    }

    @RequestMapping("/order/search_order_by_orderProduct")
    @ResponseBody
    public Page searchOrderByPro(String searchValue, int page, int rows) {
        return cOrderService.searchOrderByPro(searchValue, page, rows);
    }
    //删除订单
    @RequestMapping("/order/delete_batch")
    @ResponseBody
    public QueryStatus deleteBatch(String[] ids) {
        try {
            return cOrderService.deleteBatchOrder(ids);
        } catch (Exception e) {
            QueryStatus queryStatus = new QueryStatus();
            queryStatus.setStatus(0);
            queryStatus.setMsg(e.getMessage());
            return queryStatus;
        }
    }
    @RequestMapping("/order/delete_judge")
    @ResponseBody
    public QueryStatus deleteJudge() {
        return new QueryStatus();
    }


}
