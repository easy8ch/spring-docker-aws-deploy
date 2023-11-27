package com.goorm.tricountapi.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginRequest {
    @NotNull
    private String loginId;
    @NotNull
    private String password;
}
