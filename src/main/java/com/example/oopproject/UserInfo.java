package com.example.oopproject;

import java.io.Serializable;
import java.util.Comparator;

public class UserInfo implements Serializable, Comparator<UserInfo> {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String confirmPassword;

    public UserInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserInfo(String firstName, String lastName, String username, String password, String confirmPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public int compare(UserInfo o1, UserInfo o2) {
        int flag = 1;
        if(o1.username.equals(o2.username) && o1.password.equals(o2.password))
            flag=0;

        return flag;
    }
}
