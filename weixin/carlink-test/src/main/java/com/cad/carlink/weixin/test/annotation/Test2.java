package com.cad.carlink.weixin.test.annotation;

/**
 * 注解的用法
 */

@MyAnnotation(author = "莫言",
age = 65,
literatureType = ELiteratureType.SANWEN,
nullable = false,
style = Person.class,
myAnnotationOneMember = @MyAnnotationOneMember(desc = "山东高密"))
public class Test2 {
}
