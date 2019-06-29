/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: final_measuret_check
 * Author:   Administrator
 * Date:     2019/6/26 17:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.az.bean;

import java.util.Date;


public class FinalMeasuretCheck {
   private String fMeasureCheckId;
   private String OrderId;
   private String CheckItem;
   private Date cdate;
   private String MeasureData;
   private String EmpId;
    private String empName;
    private String result;
    private String note;

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }



    public FinalMeasuretCheck() {
    }

    public FinalMeasuretCheck(String FMeasureCheckId, String orderId, String checkItem, Date cdate, String measureData, String empId, String result, String note) {
        this.fMeasureCheckId = FMeasureCheckId;
        OrderId = orderId;
        CheckItem = checkItem;
        this.cdate = cdate;
        MeasureData = measureData;
        EmpId = empId;
        this.result = result;
        this.note = note;
    }

    public String getfMeasureCheckId() {
        return fMeasureCheckId;
    }

    public void setfMeasureCheckId(String FMeasureCheckId) {
        this.fMeasureCheckId = FMeasureCheckId;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getCheckItem() {
        return CheckItem;
    }

    public void setCheckItem(String checkItem) {
        CheckItem = checkItem;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public String getMeasureData() {
        return MeasureData;
    }

    public void setMeasureData(String measureData) {
        MeasureData = measureData;
    }

    public String getEmpId() {
        return EmpId;
    }

    public void setEmpId(String empId) {
        EmpId = empId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}