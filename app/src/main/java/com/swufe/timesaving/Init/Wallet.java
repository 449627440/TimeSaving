package com.swufe.timesaving.Init;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;

public class Wallet extends BmobObject implements Serializable {
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
    private String passwd;
}
