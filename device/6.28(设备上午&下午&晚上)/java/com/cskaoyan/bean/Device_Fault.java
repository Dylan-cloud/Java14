package com.cskaoyan.bean;

import java.util.Date;

public class Device_Fault {
    private String deviceFaultCause;
    private Date deviceFaultDate;
    private String deviceFaultDetail;
    private String deviceFaultId;
    private String deviceFaultMaintenance;
    private String deviceId;
    private String deviceName;
    private Device dev;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Device getDev() {
        return dev;
    }

    public void setDev(Device dev) {
        this.dev = dev;
    }

    public String getDeviceFaultId() {
        return deviceFaultId;
    }

    public void setDeviceFaultId(String deviceFaultId) {
        this.deviceFaultId = deviceFaultId == null ? null : deviceFaultId.trim();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getDeviceFaultCause() {
        return deviceFaultCause;
    }

    public void setDeviceFaultCause(String deviceFaultCause) {
        this.deviceFaultCause = deviceFaultCause == null ? null : deviceFaultCause.trim();
    }

    public String getDeviceFaultDetail() {
        return deviceFaultDetail;
    }

    public void setDeviceFaultDetail(String deviceFaultDetail) {
        this.deviceFaultDetail = deviceFaultDetail == null ? null : deviceFaultDetail.trim();
    }

    public Date getDeviceFaultDate() {
        return deviceFaultDate;
    }

    public void setDeviceFaultDate(Date deviceFaultDate) {
        this.deviceFaultDate = deviceFaultDate;
    }

    public String getDeviceFaultMaintenance() {
        return deviceFaultMaintenance;
    }

    public void setDeviceFaultMaintenance(String deviceFaultMaintenance) {
        this.deviceFaultMaintenance = deviceFaultMaintenance == null ? null : deviceFaultMaintenance.trim();
    }

    @Override
    public String toString() {
        return "Device_Fault{" +
                "deviceFaultCause='" + deviceFaultCause + '\'' +
                ", deviceFaultDate=" + deviceFaultDate +
                ", deviceFaultDetail='" + deviceFaultDetail + '\'' +
                ", deviceFaultId='" + deviceFaultId + '\'' +
                ", deviceFaultMaintenance='" + deviceFaultMaintenance + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", dev=" + dev +
                '}';
    }

    public Device_Fault() {
    }

    public Device_Fault(String deviceFaultCause, String deviceFaultId) {
        this.deviceFaultCause = deviceFaultCause;
        this.deviceFaultId = deviceFaultId;
    }

    public Device_Fault(String deviceFaultCause, Date deviceFaultDate, String deviceFaultDetail, String deviceFaultId, String deviceFaultMaintenance, String deviceId, String deviceName, Device dev) {
        this.deviceFaultCause = deviceFaultCause;
        this.deviceFaultDate = deviceFaultDate;
        this.deviceFaultDetail = deviceFaultDetail;
        this.deviceFaultId = deviceFaultId;
        this.deviceFaultMaintenance = deviceFaultMaintenance;
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.dev = dev;
    }
}