package com.goorm.tricountapi.util;

import com.goorm.tricountapi.enums.TricountApiErrorCode;
import com.goorm.tricountapi.model.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class TricountApiExceptionHandler {
    // 커스텀 예외 하나씩 정의해서 추가

    @ExceptionHandler(TricountApiException.class)
    public ApiResponse<Object> sendtimeExceptionHandler(TricountApiException e, HttpServletResponse response) {
        TricountApiErrorCode errorCode = e.getErrorCode();
        response.setStatus(errorCode.getStatus());
        log.warn("sendtimeExceptionHandler", e);

        return new ApiResponse<>().fail(errorCode.getCode(), e.getMessage());
    }
}
