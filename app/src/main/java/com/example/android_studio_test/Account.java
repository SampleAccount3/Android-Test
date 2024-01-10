package com.example.android_studio_test;

public class Account {
    public Account(String userName, String email, int age, boolean isActive) {
        UserName = userName;
        Email = email;
        Age = age;
        IsActive = isActive;
    }

    public Account() {

    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public boolean isActive() {
        return IsActive;
    }

    public void setActive(boolean active) {
        IsActive = active;
    }

    private String UserName,Email;
    private int Age;
    private boolean IsActive;


}
