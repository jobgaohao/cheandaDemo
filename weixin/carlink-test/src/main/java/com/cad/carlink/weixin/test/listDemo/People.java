package com.cad.carlink.weixin.test.listDemo;

public class People {
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

    public People(String name,String phoneNumber){
        this.name=name;
        this.phoneNumber=phoneNumber;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
       String str=this.name+this.phoneNumber;
       return str.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        People p=(People)obj;
        return this.name.equals(p.name)&&this.phoneNumber.equals(p.phoneNumber);
    }
}
