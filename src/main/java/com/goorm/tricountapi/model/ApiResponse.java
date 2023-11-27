package com.goorm.tricountapi.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@NoArgsConstructor
@JsonPropertyOrder({"status", "results"})
public class ApiResponse<T> implements Serializable {
    private static ApiResponseStatus OK = new ApiResponseStatus(2000, "OK");

    @Getter
    private ApiResponseStatus status;
    @Getter
    private List<T> results;

    // 생성자 역할
    public ApiResponse<T> ok() {
        this.status = OK;
        return this;
    }

    public ApiResponse<T> ok(List<T> results) {
        this.status = OK;
        this.results = results;
        return this;
    }

    public ApiResponse<T> ok(T result) {
        return ok(Collections.singletonList(result));
    }

    public ApiResponse<T> fail(int code, String message) {
        this.status = new ApiResponseStatus(code, message);
        return this;
    }

    @NoArgsConstructor
    public static class ApiResponseStatus implements Serializable {
        @Getter
        private int code;
        @Getter
        private String message;

        public ApiResponseStatus(int code, String message) {
            this.code = code;
            this.message = message;
        }
    }
}
