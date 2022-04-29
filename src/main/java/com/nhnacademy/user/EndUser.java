package com.nhnacademy.user;

import com.nhnacademy.common.object.dataStructure.User;

public class EndUser implements User {
    private String id;
    private String pw;
    private String name;
    private String profileFileName;

    public EndUser(String id, String pw, String name, String profileFileName) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.profileFileName = profileFileName;
    }

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
        return this.profileFileName;
    }

    @Override
    public void setProfileFileName(String profileFileName) {
        this.profileFileName = profileFileName;
    }
}
