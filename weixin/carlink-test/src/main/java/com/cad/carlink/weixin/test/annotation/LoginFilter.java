package com.cad.carlink.weixin.test.annotation;


import com.cad.carlink.common.constant.Constants;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest httpRequest,
                                HttpServletResponse httpResponse, Object arg2, Exception arg3)
            throws Exception {

    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {


    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object object) throws Exception {

        UserPo user=new UserPo();
        user.setRealname("张三");
        user.setOrganizationname("湖北车安达科技有限公司");
        user.setNickname("Tom");
        user.setCellphone("13122079487");
        request.setAttribute(Constants.CURRENT_USER,user);
        return true;
    }
}
