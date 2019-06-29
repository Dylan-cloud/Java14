/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: EUDataGridResult
 * Author:   Administrator
 * Date:     2019/6/27 20:10
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.az.bean;

import java.util.List;

/**
 这是分页bean
 */
public class EUDataGridResult {
    private long total;
    private List<?> rows;
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