package com.cad.carlink.weixin.test.SpringDependsOnDemo;

/**
 * 事件发布类，通过EventManager类发布事件。
 */
public class EventPublisherBean {

    public void initialize() {
        System.out.println("EventPublisherBean初始化");
        EventManager.getInstance().publish("event published from EventPublisherBean");
    }
}
