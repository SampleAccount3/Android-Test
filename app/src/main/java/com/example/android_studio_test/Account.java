package com.example.android_studio_test;

public class Account {

    public Account(int ID, String userName, String email, int age, boolean isActive) {
        this.ID = ID;
        UserName = userName;
        Email = email;
        Age = age;
        IsActive = isActive;
    }

    public Account() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    @Override
    public String toString() {
        return "Account{" +
                "ID=" + ID +
                ", UserName='" + UserName + '\'' +
                ", Email='" + Email + '\'' +
                ", Age=" + Age +
                ", IsActive=" + IsActive +
                '}';
    }

    private int ID;
    private String UserName,Email;
    private int Age;
    private boolean IsActive;


}
