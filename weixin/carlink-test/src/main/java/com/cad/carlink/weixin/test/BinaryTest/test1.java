package com.cad.carlink.weixin.test.BinaryTest;

import com.cad.carlink.common.enums.VehicleStateEnum;

import java.util.Base64;
import java.util.List;

public class test1 {

    public static void main(String[] args) {
        long longValue =262147;
        String binaryString = Long.toBinaryString(longValue);
        if (binaryString.length() < 32) {
            binaryString = String.format("%0" + (32 - binaryString.length()) + "d%s", 0, binaryString);
        }
        System.out.println(binaryString);
        List<VehicleStateEnum> a= VehicleStateEnum.getEnumsByBinaryStr(binaryString);
        getMAC();
    }


    public static void getMAC(){
        String macValue="ATMCOCMG";
        byte[] bytes = Base64.getDecoder().decode(macValue);
        String mac = BytesUtils.toHexString(bytes);
        System.out.println("http://114.119.9.163:8802/proxy/fetchMacDataService?macAddress="+mac);
        //http://114.119.9.163:8802/proxy/fetchMacDataService?macAddress=0018F534B6F5
    }


}
