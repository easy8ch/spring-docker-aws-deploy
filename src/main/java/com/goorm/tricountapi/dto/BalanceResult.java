package com.goorm.tricountapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BalanceResult {
    private Long senderMemberId;
    private String senderMemberName;
    private BigDecimal sendAmount;
    private Long receiverMemberId;
    private String receiverMemberName;
}
