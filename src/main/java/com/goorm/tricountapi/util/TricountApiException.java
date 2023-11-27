package com.goorm.tricountapi.util;

import com.goorm.tricountapi.enums.TricountApiErrorCode;

public class TricountApiException extends RuntimeException{
    private TricountApiErrorCode errorCode = TricountApiErrorCode.UNCATEGORIZED;

    public TricountApiException(String message, TricountApiErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public TricountApiErrorCode getErrorCode() {
        return errorCode;
    }
}
