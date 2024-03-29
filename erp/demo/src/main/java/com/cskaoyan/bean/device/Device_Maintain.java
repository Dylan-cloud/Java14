package com.cskaoyan.bean.device;

import java.math.BigDecimal;
import java.util.Date;

public class Device_Maintain {
    private String deviceMaintainId;

    private String deviceFaultId;

    private Device_Fault devFault;

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
        return devFault;
    }

    public void setDeviceFault(Device_Fault deviceFault) {
        this.devFault = deviceFault;
    }


    @Override
    public String toString() {
        return "Device_Maintain{" +
                "deviceMaintainId='" + deviceMaintainId + '\'' +
                ", deviceFaultId='" + deviceFaultId + '\'' +
                ", devFault=" + devFault +
                ", deviceMaintainEmpId='" + deviceMaintainEmpId + '\'' +
                ", deviceMaintainDate=" + deviceMaintainDate +
                ", deviceMaintainResult='" + deviceMaintainResult + '\'' +
                ", deviceMaintainCost=" + deviceMaintainCost +
                ", note='" + note + '\'' +
                '}';
    }

    public Device_Maintain() {
    }

    public Device_Maintain(String deviceMaintainId, String deviceFaultId, Device_Fault devFault, String deviceMaintainEmpId, Date deviceMaintainDate, String deviceMaintainResult, BigDecimal deviceMaintainCost, String note) {
        this.deviceMaintainId = deviceMaintainId;
        this.deviceFaultId = deviceFaultId;
        this.devFault = devFault;
        this.deviceMaintainEmpId = deviceMaintainEmpId;
        this.deviceMaintainDate = deviceMaintainDate;
        this.deviceMaintainResult = deviceMaintainResult;
        this.deviceMaintainCost = deviceMaintainCost;
        this.note = note;
    }

    public Device_Maintain(String deviceFaultId, String deviceMaintainEmpId, Date deviceMaintainDate, String deviceMaintainResult, BigDecimal deviceMaintainCost, String note) {
        this.deviceFaultId = deviceFaultId;
        this.deviceMaintainEmpId = deviceMaintainEmpId;
        this.deviceMaintainDate = deviceMaintainDate;
        this.deviceMaintainResult = deviceMaintainResult;
        this.deviceMaintainCost = deviceMaintainCost;
        this.note = note;
    }
}