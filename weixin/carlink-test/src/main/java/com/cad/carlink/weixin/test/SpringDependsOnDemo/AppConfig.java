package com.cad.carlink.weixin.test.SpringDependsOnDemo;

import org.springframework.context.annotation.*;

/**
 * 配置运行类
 */
@Configuration
@ComponentScan("com.cad.carlink.weixin.test.SpringDependsOnDemo")
public class AppConfig {

    @Bean(name = "eventPublisher",initMethod = "initialize")
    @DependsOn("eventListener")
    public EventPublisherBean eventPublisherBean () {
        return new EventPublisherBean();
    }

    @Bean(name = "eventListener", initMethod = "initialize")
    // @Lazy
    public EventListenerBean eventListenerBean () {
        return new EventListenerBean();
    }

    public static void main (String[] args) {
        //使用AnnotationConfigApplicationContext可以实现基于Java的配置类加载Spring的应用上下文。避免使用application.xml进行配置。相比XML配置，更加便捷。
        new AnnotationConfigApplicationContext(AppConfig.class);
    }
}

