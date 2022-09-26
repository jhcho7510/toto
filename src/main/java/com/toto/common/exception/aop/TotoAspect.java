package com.toto.common.exception.aop;


import com.toto.common.exception.TotoErrorcode;
import com.toto.common.exception.TotoExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class TotoAspect {
    /** 1.Logging */
    @AfterThrowing(pointcut = "execution(* com.toto..*(..))", throwing = "exception")
    public void totoErrorcode(Exception exception) throws Throwable {
        log.info("Ex message : {} ",exception.getMessage());
    }
}
