package com.lmall.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lmall.util.AopLogUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by reckywangbowen_i on 2019/03/06
 */
@Component
@Aspect
public class PortalLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(PortalLogAspect.class);
    @Autowired
    private ObjectMapper objectMapper;

    @Pointcut("execution(* com.lmall.service..*.*(..))")
    public void servicePointCut(){

    }

    @Around("servicePointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        return AopLogUtil.recordFunctionLog(joinPoint, objectMapper, logger);
    }


}
