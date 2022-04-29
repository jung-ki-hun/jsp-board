package com.nhnacademy.admin;

import com.nhnacademy.common.object.dataStructure.User;

public class Admin implements User {
    private String id;
    private String pw;
    private String name;
    private String profileFileName = null;

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getPassword() {
        return this.pw;
    }

    @Override
    public void setPassword(String password) {
        this.pw = password;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getProfileFileName() {
        return null;
    }

    @Override
    public void setProfileFileName(String profileFileName) {
        //note : 관리자의 경우 이미지 등록 이벤트가 발생하지 않아야된다. 따라서 구현 x
    }
}
