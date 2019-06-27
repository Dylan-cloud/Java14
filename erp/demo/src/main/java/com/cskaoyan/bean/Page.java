package com.cskaoyan.bean;

import java.util.List;

/**
 * @Author: TXJ
 * @Date: 2019/6/27 15:11
 * @Version 1.0
 */
//封装一个分页对象
public class Page {
    private long total;//总数
    private List<?> rows;//一个页面对象中含有的泛型list

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
