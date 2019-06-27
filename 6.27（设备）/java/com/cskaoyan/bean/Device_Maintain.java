package com.cskaoyan.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Device_Maintain {
    private String deviceMaintainId;

    private String deviceFaultId;

    private Device_Fault deviceFault;

    private String deviceMaintainEmpId;

    private Date deviceMaintainDate;

    private String deviceMaintainResult;

    private BigDecimal deviceMaintainCost;

    private String note;

    public String getDeviceMaintainId() {
        return deviceMaintainId;
    }

    public void setDeviceMaintainId(String deviceMaintainId) {
        this.deviceMaintainId = deviceMaintainId == null ? null : deviceMaintainId.trim();
    }

    public String getDeviceFaultId() {
        return deviceFaultId;
    }

    public void setDeviceFaultId(String deviceFaultId) {
        this.deviceFaultId = deviceFaultId == null ? null : deviceFaultId.trim();
    }

    public String getDeviceMaintainEmpId() {
        return deviceMaintainEmpId;
    }

    public void setDeviceMaintainEmpId(String deviceMaintainEmpId) {
        this.deviceMaintainEmpId = deviceMaintainEmpId == null ? null : deviceMaintainEmpId.trim();
    }

    public Date getDeviceMaintainDate() {
        return deviceMaintainDate;
    }

    public void setDeviceMaintainDate(Date deviceMaintainDate) {
        this.deviceMaintainDate = deviceMaintainDate;
    }

    public String getDeviceMaintainResult() {
        return deviceMaintainResult;
    }

    public void setDeviceMaintainResult(String deviceMaintainResult) {
        this.deviceMaintainResult = deviceMaintainResult == null ? null : deviceMaintainResult.trim();
    }

    public BigDecimal getDeviceMaintainCost() {
        return deviceMaintainCost;
    }

    public void setDeviceMaintainCost(BigDecimal deviceMaintainCost) {
        this.deviceMaintainCost = deviceMaintainCost;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Device_Fault getDeviceFault() {
        return deviceFault;
    }

    public void setDeviceFault(Device_Fault deviceFault) {
        this.deviceFault = deviceFault;
    }

    @Override
    public String toString() {
        return "Device_Maintain{" +
                "deviceMaintainId='" + deviceMaintainId + '\'' +
                ", deviceFaultId='" + deviceFaultId + '\'' +
                ", deviceFault=" + deviceFault +
                ", deviceMaintainEmpId='" + deviceMaintainEmpId + '\'' +
                ", deviceMaintainDate=" + deviceMaintainDate +
                ", deviceMaintainResult='" + deviceMaintainResult + '\'' +
                ", deviceMaintainCost=" + deviceMaintainCost +
                ", note='" + note + '\'' +
                '}';
    }
}