package com.cskaoyan.service.plan.impl;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.plan.Product;
import com.cskaoyan.mapper.plan.ProductMapper;
import com.cskaoyan.service.plan.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author: TXJ
 * @Date: 2019/6/28 10:53
 * @Version 1.0
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;

    @Override
    public Page findAllProduct(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<Product> products=productMapper.findAllProduct();
        Page page1=new Page();
        page1.setRows(products);
        PageInfo<Product> pageInfo=new PageInfo<>(products);
        page1.setTotal(pageInfo.getTotal());
        return page1;
    }

    @Override
    public List<Product> find() {
        List<Product> list=productMapper.findAllProduct();
        return list;
    }

    @Override
    public QueryStatus updateNote(Product product) {
        QueryStatus queryStatus=new QueryStatus();
        int ret=productMapper.updateNote(product);
        if (ret==1){
            queryStatus.setStatus(200);
            queryStatus.setMsg("ok");
        }
        return queryStatus;
    }

    @Override
    public QueryStatus insert(Product product) {
        QueryStatus queryStatus=new QueryStatus();
        try {
            int ret=productMapper.insert(product);//异常语句
            if (ret==1){
                queryStatus.setStatus(200);
                queryStatus.setMsg("ok");
            }
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("该产品编号已存在，请更换编号");
        }

        return queryStatus;
    }


    @Override
    public QueryStatus updateByPrimaryKeySelective(Product product) {
        QueryStatus queryStatus=new QueryStatus();
        try{
            int ret=productMapper.updateByPrimaryKeySelective(product);
            if (ret==1){
                queryStatus.setStatus(200);
                queryStatus.setMsg("ok");
            }
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("该商品已存在，请更换商品编号");
        }
        return queryStatus;
    }

    @Override
    public QueryStatus deleteBatch(String[] ids) {
        QueryStatus queryStatus=new QueryStatus();
        try{
            for (String id:ids){
               productMapper.deleteByPrimaryKey(id);
            }
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("删除出现故障，请重新尝试");
        }
        return queryStatus;
    }

    @Override
    public Page searchProductById(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Product> list = productMapper.searchProductByProductId(searchValue);
        Page page1 = new Page();
        //设置行数
        page1.setRows(list);
        //取记录的总条数
        PageInfo<Product> pageInfo = new PageInfo<>(list);
        page1.setTotal(pageInfo.getTotal());
        return page1;
    }

    @Override
    public Page searchProductByName(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Product> list = productMapper.searchProductByProductName(searchValue);
        Page page1 = new Page();
        //设置行数
        page1.setRows(list);
        //取记录的总条数
        PageInfo<Product> pageInfo = new PageInfo<>(list);
        page1.setTotal(pageInfo.getTotal());
        return page1;
    }

    @Override
    public Page searchProductByType(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Product> list = productMapper.searchProductByProductType(searchValue);
        Page page1 = new Page();
        //设置行数
        page1.setRows(list);
        //取记录的总条数
        PageInfo<Product> pageInfo = new PageInfo<>(list);
        page1.setTotal(pageInfo.getTotal());
        return page1;
    }
}
