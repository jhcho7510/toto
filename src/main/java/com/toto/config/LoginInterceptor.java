package com.toto.config;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    /** 클라이언트요청을 컨트롤러에 전달하기전에호출,
     * 반환값이 false이면 컨트롤로 실해하지 앟는다.*/
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        return true;
    }

    /** 클라이언트의 요청을 처리한 뒤 호출된다.
     * 컨트롤러에서 예외가 발생하면 실행되지않는다.
     * */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) {
    }

    /** 클라이언트 요청을 마치고, 클라인트에서 뷰를 통해 응답을 전송한 뒤 실행.
     * 뷰생성시 예외 발생해도 실행됨.
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception exception) throws Exception {

    }

}
