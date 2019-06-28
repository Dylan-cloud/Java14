package com.cskaoyan.mapper.plan;

import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.plan.Product;

import java.util.List;

public interface ProductMapper {
    List<Product> findAllProduct();
    List<Product> searchProductByProductId(String ProductId);
    List<Product> searchProductByProductName(String ProductName);
    List<Product> searchProductByProductType(String ProductType);
    int  updateNote(Product product);
    //逆向方法，删除插入修改都可直接用
    int deleteByPrimaryKey(String productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(String productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}