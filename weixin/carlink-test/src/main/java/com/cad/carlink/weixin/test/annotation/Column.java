package com.cad.carlink.weixin.test.annotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD})//列
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Column {

     String columnName();

     ESearchType searchType();
}
