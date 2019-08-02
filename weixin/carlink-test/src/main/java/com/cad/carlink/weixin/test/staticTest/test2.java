package com.cad.carlink.weixin.test.staticTest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class test2 {
    public static void main(String[] args) throws ParseException {
        String datetime="2019-10-01 11:00:00";
        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateStart=sDateFormat.parse(datetime);
        test1();
    }

    public  static void test1(){
        List<String> list=new ArrayList<>();
        list.add("鄂A11111");
        list.add("鄂A22222");
        list.add("鄂A33333");

        String ss = String.join(",", list);
        System.out.println(StringUtils.join("",list));
        System.out.println(ss);

        System.out.println(convertListToString(list));
    }


    public static String convertListToString(List<String> strlist){
        StringBuffer sb = new StringBuffer();
        if(CollectionUtils.isNotEmpty(strlist)){
            for (int i=0;i<strlist.size();i++) {
                if(i==0){
                    sb.append("\"").append(strlist.get(i)).append("\"");
                }else{
                    sb.append(",").append("\"").append(strlist.get(i)).append("\"");
                }
            }
        }
        return sb.toString();
    }

}
