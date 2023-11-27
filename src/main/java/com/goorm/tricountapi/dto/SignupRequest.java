package com.goorm.tricountapi.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SignupRequest {
    @NotNull
    private String loginId;
    @NotNull
    private String password;
    @NotNull
    private String name;
}
