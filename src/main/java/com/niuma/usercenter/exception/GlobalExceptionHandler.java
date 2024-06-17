package com.niuma.usercenter.exception;

import com.niuma.usercenter.common.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class GlobalExceptionHandler {

    public BaseResponse businessExceptionHandler(BusinessException exception) {
        log.error("businessException: " + exception.getMessage());
    }
}
