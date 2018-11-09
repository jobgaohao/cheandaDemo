package com.cad.carlink.weixin.converter;

/**
 * Created by LS on 2017-12-25.
 *
 * @author LS.
 */
public class RequestBodyThreadLocal {
    private static ThreadLocal<String> requestBodyThreadLocal = new ThreadLocal<>();

    public static String get() {
        return requestBodyThreadLocal.get();
    }

    public static void set(String requestBody) {
        requestBodyThreadLocal.set(requestBody);
    }
}
