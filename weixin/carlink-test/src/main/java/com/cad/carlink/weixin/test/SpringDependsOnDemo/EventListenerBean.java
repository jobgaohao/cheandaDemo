package com.cad.carlink.weixin.test.SpringDependsOnDemo;

/**
 * 事件监听者，可以增加监听器
 */
public class EventListenerBean {
    private void initialize() {
        EventManager.getInstance().
                addListener(s ->
                        System.out.println("event received in EventListenerBean : " + s));
    }

}
