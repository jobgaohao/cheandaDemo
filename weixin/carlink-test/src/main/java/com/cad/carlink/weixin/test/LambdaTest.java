package com.cad.carlink.weixin.test;

import java.util.Arrays;

public class LambdaTest {

    public static void main(String[] args) {
        try {
            Arrays.asList("a","b","c").forEach(e-> System.out.println(e));

            for (int i = 0; i <10 ; i++) {
                System.out.println(i);
            }
        }catch (Exception ex){

        }
    }
}
