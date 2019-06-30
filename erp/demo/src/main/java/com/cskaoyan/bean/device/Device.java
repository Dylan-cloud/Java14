package com.cskaoyan.bean.device;



import java.math.BigDecimal;
import java.util.Date;

public class Device {
    private String deviceId;

    private String deviceName;

    private String deviceTypeName;

    private String deviceTypeId;

    private Device_Type deviceType;

    private String deviceStatusId;

    private String deviceStatus;

    private Date devicePurchaseDate;

    private BigDecimal devicePurchasePrice;

    private Date deviceManufactureDate;

    private Date deviceServiceLife;

    private String deviceKeeperId;

    private String deviceKeeper;

    private Device_employee employee;

    private String note;


    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }


    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    public Device_Type getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Device_Type deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceStatusId() {
        return deviceStatusId;
    }

    public void setDeviceStatusId(String deviceStatusId) {
        this.deviceStatusId = deviceStatusId == null ? null : deviceStatusId.trim();
    }

    public String getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus == null ? null : deviceStatus.trim();
    }

    public Date getDevicePurchaseDate() {
        return devicePurchaseDate;
    }

    public void setDevicePurchaseDate(Date devicePurchaseDate) {
        this.devicePurchaseDate = devicePurchaseDate;
    }

    public BigDecimal getDevicePurchasePrice() {
        return devicePurchasePrice;
    }

    public void setDevicePurchasePrice(BigDecimal devicePurchasePrice) {
        this.devicePurchasePrice = devicePurchasePrice;
    }

    public Date getDeviceManufactureDate() {
        return deviceManufactureDate;
    }

    public void setDeviceManufactureDate(Date deviceManufactureDate) {
        this.deviceManufactureDate = deviceManufactureDate;
    }

    public Date getDeviceServiceLife() {
        return deviceServiceLife;
    }

    public void setDeviceServiceLife(Date deviceServiceLife) {
        this.deviceServiceLife = deviceServiceLife;
    }

    public String getDeviceKeeper() {
        return deviceKeeperId;
    }

    public void setDeviceKeeper(String deviceKeeper) {
        this.deviceKeeperId = deviceKeeper;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(String deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public String getDeviceKeeperId() {
        return deviceKeeperId;
    }

    public void setDeviceKeeperId(String deviceKeeperId) {
        this.deviceKeeperId = deviceKeeperId;
    }

    public Device_employee getEmployee() {
        return employee;
    }

    public void setEmployee(Device_employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Device{" +
                "deviceId='" + deviceId + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", deviceTypeName='" + deviceTypeName + '\'' +
                ", deviceTypeId='" + deviceTypeId + '\'' +
                ", deviceType=" + deviceType +
                ", deviceStatusId='" + deviceStatusId + '\'' +
                ", deviceStatus='" + deviceStatus + '\'' +
                ", devicePurchaseDate=" + devicePurchaseDate +
                ", devicePurchasePrice=" + devicePurchasePrice +
                ", deviceManufactureDate=" + deviceManufactureDate +
                ", deviceServiceLife=" + deviceServiceLife +
                ", deviceKeeperId='" + deviceKeeperId + '\'' +
                ", deviceKeeper='" + deviceKeeper + '\'' +
                ", employee=" + employee +
                ", note='" + note + '\'' +
                '}';
    }

    public Device() {
    }

    public Device(String deviceId, String deviceName, String deviceTypeName, String deviceStatusId, String deviceStatus, Date devicePurchaseDate, BigDecimal devicePurchasePrice, Date deviceServiceLife, String deviceKeeper, String note) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.deviceTypeName = deviceTypeName;
        this.deviceStatusId = deviceStatusId;
        this.deviceStatus = deviceStatus;
        this.devicePurchaseDate = devicePurchaseDate;
        this.devicePurchasePrice = devicePurchasePrice;
        this.deviceServiceLife = deviceServiceLife;
        this.deviceKeeper = deviceKeeper;
        this.note = note;
    }

    public Device(String deviceId, String deviceName, String deviceTypeName, String deviceStatusId, String deviceStatus, Date devicePurchaseDate, BigDecimal devicePurchasePrice, Date deviceServiceLife, String deviceKeeperId, String deviceKeeper, Device_employee employee, String note) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.deviceTypeName = deviceTypeName;
        this.deviceStatusId = deviceStatusId;
        this.deviceStatus = deviceStatus;
        this.devicePurchaseDate = devicePurchaseDate;
        this.devicePurchasePrice = devicePurchasePrice;
        this.deviceServiceLife = deviceServiceLife;
        this.deviceKeeperId = deviceKeeperId;
        this.deviceKeeper = deviceKeeper;
        this.employee = employee;
        this.note = note;
    }

    public Device(String deviceId, String deviceName, String deviceTypeName, String deviceTypeId, Device_Type deviceType, String deviceStatusId, String deviceStatus, Date devicePurchaseDate, BigDecimal devicePurchasePrice, Date deviceManufactureDate, Date deviceServiceLife, String deviceKeeper, String note) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.deviceTypeName = deviceTypeName;
        this.deviceTypeId = deviceTypeId;
        this.deviceType = deviceType;
        this.deviceStatusId = deviceStatusId;
        this.deviceStatus = deviceStatus;
        this.devicePurchaseDate = devicePurchaseDate;
        this.devicePurchasePrice = devicePurchasePrice;
        this.deviceManufactureDate = deviceManufactureDate;
        this.deviceServiceLife = deviceServiceLife;
        this.deviceKeeper = deviceKeeper;
        this.note = note;
    }
}