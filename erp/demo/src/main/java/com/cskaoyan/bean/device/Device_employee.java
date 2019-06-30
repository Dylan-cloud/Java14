package com.cskaoyan.bean.device;

public class Device_employee {
    private String name;
    private String code;
    private String degree;
    private String education;
    private String major;
    private String educationform;
    private String	birthday;
    private String	joinDate;
    private String	status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEducationform() {
        return educationform;
    }

    public void setEducationform(String educationform) {
        this.educationform = educationform;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Device_employee{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", degree='" + degree + '\'' +
                ", education='" + education + '\'' +
                ", major='" + major + '\'' +
                ", educationform='" + educationform + '\'' +
                ", birthday='" + birthday + '\'' +
                ", joinDate='" + joinDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public Device_employee() {
    }

    public Device_employee(String name, String code, String degree, String education, String major, String educationform, String birthday, String joinDate, String status) {
        this.name = name;
        this.code = code;
        this.degree = degree;
        this.education = education;
        this.major = major;
        this.educationform = educationform;
        this.birthday = birthday;
        this.joinDate = joinDate;
        this.status = status;
    }
}
