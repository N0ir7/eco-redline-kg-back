package com.redline.ecoredlinekgback.advice;

import com.redline.ecoredlinekgback.exception.ServiceException;
import com.redline.ecoredlinekgback.vo.Result;
import com.redline.ecoredlinekgback.vo.ResultCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(ServiceException.class)
    public Result exceptionHandler(ServiceException e){
        return Result.fail(e.getCode());
    }

    @ExceptionHandler(IOException.class)
    public Result exceptionHandler(IOException e){
        return Result.fail(ResultCode.IO_ERROR);
    }
}
