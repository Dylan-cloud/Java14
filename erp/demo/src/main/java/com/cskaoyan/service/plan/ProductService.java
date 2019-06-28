package com.cskaoyan.service.plan;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.plan.Product;

import java.util.List;

/**
 * @Author: TXJ
 * @Date: 2019/6/28 10:53
 * @Version 1.0
 */
public interface ProductService {

    Page findAllProduct(int page, int rows);

    QueryStatus insert(Product product);

    QueryStatus updateByPrimaryKeySelective(Product product);

    QueryStatus deleteBatch(String[] ids);

    Page searchProductById(String searchValue, int page, int rows);

    Page searchProductByName(String searchValue, int page, int rows);

    Page searchProductByType(String searchValue, int page, int rows);

    QueryStatus updateNote(Product product);

    List<Product> find();
}
