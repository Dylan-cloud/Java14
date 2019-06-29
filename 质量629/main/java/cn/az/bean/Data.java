/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Data
 * Author:   Administrator
 * Date:     2019/6/27 17:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.az.bean;


public class Data {

    private int status;
    private String msg;

    public Data() {
    }

    public Data(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}