package com.ashitech.sqlitedemo;

/**
 * Created by Ashin on 4/2/2018.
 */

class ContactInfo {

    private String userName;
    private String userContactNumber;
    private String userEmail;

    public ContactInfo(String userName, String userContactNumber, String userEmail) {
        this.userName = userName;
        this.userContactNumber = userContactNumber;
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserContactNumber() {
        return userContactNumber;
    }

    public void setUserContactNumber(String userContactNumber) {
        this.userContactNumber = userContactNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
