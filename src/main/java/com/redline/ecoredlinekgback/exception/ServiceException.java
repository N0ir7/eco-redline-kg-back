package com.redline.ecoredlinekgback.exception;

import com.redline.ecoredlinekgback.vo.ResultCode;
import lombok.Data;

@Data
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 2797060340861735113L;

    ResultCode code;

    public ServiceException(ResultCode resultCode) {
        code = resultCode;
    }

    public ServiceException(ResultCode resultCode, Throwable cause) {
        super(cause);
        code = resultCode;
    }

}
