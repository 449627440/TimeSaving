package com.swufe.timesaving.Init;

import cn.bmob.v3.BmobUser;

public class User extends BmobUser {
    private String headPortrait;
    private String nickName;
    private String name;
    private String IDCard;
    private String age;
    private String emergentPerson;
    private String emergentPhone;
    private String province;
    private String city;
    private String county;
    private String street;
    private String briefIntro;
    private String coin;

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmergentPerson() {
        return emergentPerson;
    }

    public void setEmergentPerson(String emergentPerson) {
        this.emergentPerson = emergentPerson;
    }

    public String getEmergentPhone() {
        return emergentPhone;
    }

    public void setEmergentPhone(String emergentPhone) {
        this.emergentPhone = emergentPhone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBriefIntro() {
        return briefIntro;
    }

    public void setBriefIntro(String briefIntro) {
        this.briefIntro = briefIntro;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
