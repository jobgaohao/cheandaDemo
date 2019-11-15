package com.cad.carlink.weixin.test.BinaryTest;

import java.nio.charset.Charset;

public class BytesUtils {
    public static byte[] getBytesWithGBK(String s) {
        return s.getBytes(Charset.forName("GBK"));
    }

    /**
     * 将字节转换为16进制字符串
     *
     * @param bts
     * @return
     */
    public static String toHexString(byte[] bts) {
        StringBuilder strBuild = new StringBuilder();
        for (int i = 0; i < bts.length; i++) {
            strBuild.append(toHexString(bts[i]));
        }
        return strBuild.toString().toUpperCase();
    }

    /**
     * 将数字转换成16进制字符串，不足补零
     *
     * @param data
     * @return
     */
    public static String toHexString(byte data) {
        return Integer.toHexString(data & 0xff | 0x100).substring(1);
    }
}
