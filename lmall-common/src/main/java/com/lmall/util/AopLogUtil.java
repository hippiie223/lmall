package com.lmall.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by reckywangbowen_i on 2019/03/06
 */
public class AopLogUtil {
    public static Object recordFunctionLog(ProceedingJoinPoint joinPoint, ObjectMapper objectMapper, Logger logger) throws Throwable {
        Signature signature = joinPoint.getSignature();
        long start = System.currentTimeMillis();
        StringBuilder logBuilder = new StringBuilder();
        //方法名
        logBuilder.append(signature.toString()).append("||");

        Object[] args = joinPoint.getArgs();
        List<String> argList = new ArrayList<>();
        if (args.length > 0) {
            for (Object arg : args) {
                argList.add(convertArg(arg, objectMapper, logger));
            }
        }
        //参数
        logBuilder.append("args:(").append(String.join(",", argList)).append(")||");
        //执行方法
        Object returnObj = null;
        try {
            returnObj = joinPoint.proceed();
        } catch (Throwable throwable) {
            if (throwable instanceof RuntimeException) {
                logger.error("runtime exception {}, message:{}, trace:{}", throwable.getClass().getName(), throwable.getMessage(), throwable);
            }
            logBuilder.append("execute error, exception: ").append(throwable.getClass().toString());
            logBuilder.append("||message: ").append(throwable.getMessage());
            logger.warn(logBuilder.toString());
            throw throwable;
        }
        logBuilder.append("return: ").append(convertArg(returnObj, objectMapper, logger)).append("||");
        long end = System.currentTimeMillis();
        //执行耗时
        logBuilder.append("time: ").append(end - start);
        logger.info(logBuilder.toString());
        //返回值
        return returnObj;
    }

    private static String convertArg(Object arg, ObjectMapper objectMapper, Logger logger) {
        try {
            if (arg == null) {
                return "null";
            } if (arg instanceof String) {
                String argStr = (String) arg;
                return argStr.length() < 1000 ? argStr : argStr.substring(0, 1000);
            } else if (arg instanceof Collection || arg instanceof Map) {
                String json = objectMapper.writeValueAsString(arg);
                return json.length() < 1000 ? json : json.substring(0, 1000);
            } else if (arg.getClass().getName().startsWith("com.lmall")) {
                String json = objectMapper.writeValueAsString(arg);
                return json.length() < 1000 ? json : json.substring(0, 1000);
            } else {
                return arg.toString();
            }
        } catch (Exception e) {
            logger.error("convert method args error, {}", e);
        }
        return "null";
    }
}
