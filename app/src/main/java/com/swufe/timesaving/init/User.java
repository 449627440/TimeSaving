package com.swufe.timesaving.init;

import cn.bmob.v3.BmobUser;

public class User extends BmobUser {
    private String headPortrait;
    private String nickname;

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
