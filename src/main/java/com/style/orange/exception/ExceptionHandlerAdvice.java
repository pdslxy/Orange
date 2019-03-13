package com.style.orange.exception;

import com.style.orange.enums.OrangeResultCode;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Mr.Li
 * @create 2018-07-31 11:18
 * @desc 异常处理切面
 **/
@RestControllerAdvice
@ResponseBody
public class ExceptionHandlerAdvice implements ResponseBodyAdvice {


    @ExceptionHandler(OrangeException.class)
    public Map<String, Object> handleResultException(OrangeException e, HttpServletRequest request) {
        Map<String, Object> map = new LinkedHashMap<>(2);
        map.put("code", e.getOrangeResultCode().getCode());
        map.put("msg", e.getOrangeResultCode().getMsg());
        return map;
    }

    @ExceptionHandler(Exception.class)
    public Map<String, Object> handleException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new LinkedHashMap<>(2);
        map.put("code", OrangeResultCode.ERROR_SYSTEM.getCode());
        map.put("msg", OrangeResultCode.ERROR_SYSTEM.getMsg());
        return map;
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        return o;
    }
}
