package com.swufe.timesaving.Init;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;

public class Received extends BmobObject implements Serializable {
    private String username;
    private String iD;
    private String name;
    private String type;
    private String peopleNum;
    private String coinNum;
    private String detail;
    private String typeImage;
    private String startDate;
    private String startMonth;
    private String startYear;
    private String endDate;
    private String endMonth;
    private String endYear;
    private String detailAddress;
    private String cityName;
    private String provinceName;
    private String districtName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getTypeImage() {
        return typeImage;
    }

    public void setTypeImage(String typeImage) {
        this.typeImage = typeImage;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(String startMonth) {
        this.startMonth = startMonth;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(String peopleNum) {
        this.peopleNum = peopleNum;
    }

    public String getCoinNum() {
        return coinNum;
    }

    public void setCoinNum(String coinNum) {
        this.coinNum = coinNum;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(String endMonth) {
        this.endMonth = endMonth;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }
}
