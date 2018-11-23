package com.cad.carlink.weixin.test.annotation;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import java.lang.annotation.Annotation;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
        Annotation[]  methodAnnotations= parameter.getParameterAnnotations();
        for(Annotation  annotation:methodAnnotations){
            if(annotation instanceof CustomerDate){
                CustomerDate  customerDate=(CustomerDate)annotation;
                if(customerDate!=null){
                    String dataStringValue=customerDate.value();
                    SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    return  formater.parse(dataStringValue);
                }
            }
            else if(annotation instanceof UserInfo){
                UserInfo userInfo=(UserInfo)annotation;
                if(userInfo!=null){
                    return webRequest.getAttribute(userInfo.value(), NativeWebRequest.SCOPE_REQUEST);
                }
            }
        }
        return null;
    }

    /**
     * 过滤不支持的参数类型
     * @param parameter
     * @return
     */
    @SuppressWarnings("unchecked")
    public boolean supportsParameter(MethodParameter parameter) {
        Class  parameterType=parameter.getParameterType();
        if(parameterType.equals(Date.class)){
            return true;
        }else if(parameterType.equals(UserPo.class)){
            return true;
        }
        return false;
    }
}
