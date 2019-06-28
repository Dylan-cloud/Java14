package com.cskaoyan.service.plan;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.plan.COrder;

/**
 * @Author: TXJ
 * @Date: 2019/6/28 16:33
 * @Version 1.0
 */
public interface COrderService {
    Page findOrder(int page, int rows);

    QueryStatus insert(COrder cOrder);

    QueryStatus updateByPrimaryKeySelective(COrder cOrder);

    QueryStatus updateNote(COrder cOrder);

    Page searchProductById(String searchValue, int page, int rows);

    Page searchOrderByCustom(String searchValue, int page, int rows);

    Page searchOrderByPro(String searchValue, int page, int rows);

    QueryStatus deleteBatchOrder(String[] ids);
}
