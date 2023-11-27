package com.goorm.tricountapi.enums;

import javax.servlet.http.HttpServletResponse;

public enum TricountApiErrorCode {

    INVALID_INPUT_VALUE(HttpServletResponse.SC_BAD_REQUEST, 4001, "Invalid Input Value"),
    ENTITY_NOT_FOUND(HttpServletResponse.SC_BAD_REQUEST, 4002, "Entity Not Found"),
    INVALID_TYPE_VALUE(HttpServletResponse.SC_BAD_REQUEST, 4003, "Invalid Type Value"),
    ACCESS_DENIED(HttpServletResponse.SC_BAD_REQUEST, 4004, "Access is Denied"),
    NOT_FOUND(HttpServletResponse.SC_NOT_FOUND, 4005,"Not Found"),
    METHOD_NOT_ALLOWED(HttpServletResponse.SC_METHOD_NOT_ALLOWED, 4006, "Method Not Allowed"),
    NOT_ACCEPTABLE(HttpServletResponse.SC_NOT_ACCEPTABLE, 4007, "Not Acceptable"),
    UNSUPPORTED_MEDIA_TYPE(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE,4008, "Unsupported Media Type"),
    LOGIN_NEEDED(HttpServletResponse.SC_FORBIDDEN, 4009, "Login Required"),
    INTERNAL_SERVER_ERROR(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, 5000, "Server Error"),
    UNCATEGORIZED(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, 5001, "Uncategorized"),
    SERVICE_UNAVAILABLE(HttpServletResponse.SC_SERVICE_UNAVAILABLE, 5002, "Service Unavailable");
    private final int code;
    private final String message;
    private int status;

    TricountApiErrorCode(final int status, final int code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public int getCode() {
        return code;
    }

    public int getStatus() {
        return status;
    }
}