package com.cad.carlink.weixin.test.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Table {
    //表名称
    String value();
}
