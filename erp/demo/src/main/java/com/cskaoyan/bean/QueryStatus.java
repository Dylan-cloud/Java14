package com.cskaoyan.bean;

/**
 * @Author: TXJ
 * @Date: 2019/6/28 9:47
 * @Version 1.0
 */
public class QueryStatus {
    private int status;
    private String msg;
    private String data;
    private int error;
    private String url;

    @Override
    public String toString() {
        return "QueryStatus{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data='" + data + '\'' +
                ", error=" + error +
                ", url='" + url + '\'' +
                '}';
    }

    public QueryStatus(int status, String msg, String data, int error, String url) {
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.error = error;
        this.url = url;
    }

    public QueryStatus() {
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
