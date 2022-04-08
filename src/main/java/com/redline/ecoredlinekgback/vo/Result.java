package com.redline.ecoredlinekgback.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    public void setResultCode(ResultCode rc){
        this.code = rc.getCode();
        this.msg = rc.getMsg();
    }
    public static Result success(Object data) {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }
    public static Result fail(){
        Result result = new Result();
        result.setResultCode(ResultCode.SYSTEM_ERROR);
        return result;
    }
    public static Result fail(ResultCode code){
        Result result = new Result();
        result.setResultCode(code);
        return result;
    }
}
