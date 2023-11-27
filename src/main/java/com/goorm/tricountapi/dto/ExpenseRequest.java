package com.goorm.tricountapi.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ExpenseRequest {
    @NotNull
    private String name;

    @NotNull
    private Long settlementId;

    @NotNull
    private Long payerMemberId;

    @NotNull
    private BigDecimal amount;

    private LocalDateTime expenseDateTime;
}
