package com.niuma.usercenter.exception;

import com.niuma.usercenter.common.BaseResponse;
import com.niuma.usercenter.common.ErrorCode;
import com.niuma.usercenter.common.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public BaseResponse businessExceptionHandler(BusinessException exception) {
        log.error("businessException: " + exception.getMessage());
        return ResultUtils.error(exception.getCode(), exception.getMessage(), exception.getDescription());
    }

    @ExceptionHandler(RuntimeException.class)
    public BaseResponse businessExceptionHandler(RuntimeException exception) {
        log.error("runtimeException: " + exception.getMessage());
        return ResultUtils.error(ErrorCode.SYSTEM_ERROR, exception.getMessage(), "");
    }
}
