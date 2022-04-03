package com.redline.ecoredlinekgback.advice;

import com.redline.ecoredlinekgback.utils.JsonUtil;
import com.redline.ecoredlinekgback.vo.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice(basePackages = "com.redline.ecoredlinekgback.controller")
public class ResultResponseAdvice implements ResponseBodyAdvice<Object> {
    // 判断是否要执行beforeBodyWrite方法，true为执行，false不执行
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof Result) {
            return body;
        }else if(body instanceof String){
            return JsonUtil.object2Json(Result.success(body));
        }
        return Result.success(body);
    }
}
