package com.cad.carlink.weixin.test.CADTest;

import com.cad.carlink.common.util.DateUtils;

import java.util.Date;

public class test1 {
    public static void main(String[] args) {
        String mes="CAD"+ DateUtils.getFormatDateTime(new Date(),"yyyyMMddHHmmssms");
        System.out.println(mes);
    }
}
