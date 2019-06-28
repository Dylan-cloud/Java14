package com.cskaoyan.bean;

import java.util.Date;

public class Device_Check {
    private String deviceCheckId;

    private String deviceId;

    private String deviceName;

    private String deviceCheckEmpId;

    private String deviceCheckEmp;

    private Date deviceCheckDate;

    private String deviceCheckResult;

    private String deviceCheckFaultId;

    private Device dev;

    public String getDeviceCheckId() {
        return deviceCheckId;
    }

    public void setDeviceCheckId(String deviceCheckId) {
        this.deviceCheckId = deviceCheckId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceCheckEmpId() {
        return deviceCheckEmpId;
    }

    public void setDeviceCheckEmpId(String deviceCheckEmpId) {
        this.deviceCheckEmpId = deviceCheckEmpId;
    }

    public String getDeviceCheckEmp() {
        return deviceCheckEmp;
    }

    public void setDeviceCheckEmp(String deviceCheckEmp) {
        this.deviceCheckEmp = deviceCheckEmp;
    }

    public Date getDeviceCheckDate() {
        return deviceCheckDate;
    }

    public void setDeviceCheckDate(Date deviceCheckDate) {
        this.deviceCheckDate = deviceCheckDate;
    }

    public String getDeviceCheckResult() {
        return deviceCheckResult;
    }

    public void setDeviceCheckResult(String deviceCheckResult) {
        this.deviceCheckResult = deviceCheckResult;
    }

    public String getDeviceCheckFaultId() {
        return deviceCheckFaultId;
    }

    public void setDeviceCheckFaultId(String deviceCheckFaultId) {
        this.deviceCheckFaultId = deviceCheckFaultId;
    }

    public Device getDev() {
        return dev;
    }

    public void setDev(Device dev) {
        this.dev = dev;
    }

    @Override
    public String toString() {
        return "Device_Check{" +
                "deviceCheckId='" + deviceCheckId + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", deviceCheckEmpId='" + deviceCheckEmpId + '\'' +
                ", deviceCheckEmp='" + deviceCheckEmp + '\'' +
                ", deviceCheckDate=" + deviceCheckDate +
                ", deviceCheckResult='" + deviceCheckResult + '\'' +
                ", deviceCheckFaultId='" + deviceCheckFaultId + '\'' +
                ", dev=" + dev +
                '}';
    }

    public Device_Check() {
    }

    public Device_Check(String deviceCheckId, String deviceId, String deviceName, String deviceCheckEmpId, String deviceCheckEmp, Date deviceCheckDate, String deviceCheckResult, String deviceCheckFaultId, Device dev) {
        this.deviceCheckId = deviceCheckId;
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.deviceCheckEmpId = deviceCheckEmpId;
        this.deviceCheckEmp = deviceCheckEmp;
        this.deviceCheckDate = deviceCheckDate;
        this.deviceCheckResult = deviceCheckResult;
        this.deviceCheckFaultId = deviceCheckFaultId;
        this.dev = dev;
    }
}