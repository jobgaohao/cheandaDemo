package com.cad.carlink.weixin.test.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface UserInfo {
     String value() default Constants.CURRENT_USER;
}
