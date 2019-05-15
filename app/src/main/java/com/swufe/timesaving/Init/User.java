package com.swufe.timesaving.Init;

import cn.bmob.v3.BmobUser;

public class User extends BmobUser {
    private String headPortrait;
    private String nickName;

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
