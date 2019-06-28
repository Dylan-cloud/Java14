package com.cskaoyan.controller.plan;

import com.cskaoyan.bean.Data;
import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.plan.Product;
import com.cskaoyan.service.plan.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @Author: TXJ
 * @Date: 2019/6/28 10:50
 * @Version 1.0
 */
@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/product/find")
    public String show() {
        return "product_list";
    }
    @RequestMapping("/product/get_data")
    @ResponseBody
    public List<Product> list() throws Exception {
        List<Product> list=productService.find();
        return list;
    }
    @RequestMapping("/product/list")
    @ResponseBody
    public Page productlist(int page, int rows) {
        return productService.findAllProduct(page, rows);
    }


    @RequestMapping("/product/add_judge")
    public String customAddJudge() {
        return "product_add";
    }

    @RequestMapping("/product/add")
    public String customAdd() {
        return "product_add";
    }

    //增加产品
    @RequestMapping("/product/insert")
    @ResponseBody
    public QueryStatus productInsert(Product product) {
        return productService.insert(product);
    }

    //上传图片
    @RequestMapping("/pic/upload")
    @ResponseBody
    public QueryStatus upload(MultipartFile uploadFile, HttpServletRequest request) throws IOException {
        String fileName = uploadFile.getOriginalFilename();
        fileName = UUID.randomUUID().toString().replace("-", "").toUpperCase() + "_" + fileName;
        String contextPath = request.getContextPath();
        String path = request.getSession().getServletContext().getRealPath("/WEB-INF/image/upload/");
        File file = new File(path + fileName);
        if (!file.exists()) {
            file.mkdirs();
        }
        uploadFile.transferTo(file);
        QueryStatus queryStatus = new QueryStatus();
        queryStatus.setError(0);
        queryStatus.setUrl(contextPath + "/pic/" + fileName);
        return queryStatus;
    }

    //    pic/delete?picName
    @RequestMapping("pic/delete")
    @ResponseBody
    public Data picDelete(String picName, HttpServletRequest request) {
        String path = request.getSession().getServletContext().getRealPath("/WEB-INF/image/upload/");
        picName = picName.substring(picName.lastIndexOf("/") + 1);
        File file = new File(path + picName);
        if (file.exists()) {
            file.delete();
        }
        Data data = new Data();
        data.setData("success");
        return data;
    }


    //编辑产品
    @RequestMapping("/product/edit_judge")
    @ResponseBody
    public QueryStatus editJudge() {
        return new QueryStatus();
    }

    @RequestMapping("/product/edit")
    public String edit() {
        return "product_edit";
    }

    @RequestMapping("/product/update_all")
    @ResponseBody
    public QueryStatus updateAll(Product product) {
        return productService.updateByPrimaryKeySelective(product);
    }

    @RequestMapping("/product/update_note")
    @ResponseBody
    public QueryStatus updateNote(Product product) {

        return productService.updateNote(product);
    }

    //删除产品
    @RequestMapping("/product/delete_batch")
    @ResponseBody
    public QueryStatus deleteBatch(String[] ids) {
        try {
            return productService.deleteBatch(ids);
        } catch (Exception e) {
            QueryStatus queryStatus = new QueryStatus();
            queryStatus.setStatus(0);
            queryStatus.setMsg(e.getMessage());
            return queryStatus;
        }
    }

    @RequestMapping("/product/delete_judge")
    @ResponseBody
    public QueryStatus deleteJudge() {
        return new QueryStatus();
    }

    //查询产品
    @RequestMapping("/product/search_product_by_productId")
    @ResponseBody
    public Page searchProductById(String searchValue, int page, int rows) {
        return productService.searchProductById(searchValue, page, rows);
    }

    @RequestMapping("/product/search_product_by_productName")
    @ResponseBody
    public Page searchProductByName(String searchValue, int page, int rows) {
        return productService.searchProductByName(searchValue, page, rows);
    }

    @RequestMapping("/product/search_product_by_productType")
    @ResponseBody
    public Page searchProductByType(String searchValue, int page, int rows) {
        return productService.searchProductByType(searchValue, page, rows);
    }
}
