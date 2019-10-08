package com.cad.carlink.weixin.test.listDemo;

public class Student {
    private String name;
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Student(String name,String phoneNumber){
        this.name=name;
        this.phoneNumber=phoneNumber;
    }
}
