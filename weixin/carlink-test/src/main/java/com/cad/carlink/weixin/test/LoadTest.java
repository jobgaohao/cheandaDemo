package com.cad.carlink.weixin.test;


import java.util.ArrayList;
import java.util.List;

/**
 *  模拟负载测试
 */
public class LoadTest {
    public static void main(String[] args) {
        List<String>  attachmentInfos=new ArrayList<>();
        attachmentInfos.add("附件服务器1");
        attachmentInfos.add("附件服务器2");
        attachmentInfos.add("附件服务器3");

        List<String> plateNumList=new ArrayList<>();
        plateNumList.add("琼D18617");
        plateNumList.add("琼A75872");
        plateNumList.add("琼A80637");
        plateNumList.add("琼A80838");
        plateNumList.add("琼A80960");
        plateNumList.add("琼A81066");

        for (String plateNum:plateNumList) {
            int attachmentIndex=plateNum.hashCode()%attachmentInfos.size();
            System.out.println(String.format("plateNum:%s,attachmentInfo:%s",plateNum, attachmentInfos.get(attachmentIndex)));
        }
    }
}
