package com.example.android_studio_test;

public class ObjectBattery {
    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    String name;
    int image;

    public ObjectBattery(String name,int image) {
        this.name = name;
        this.image = image;
    }
}
