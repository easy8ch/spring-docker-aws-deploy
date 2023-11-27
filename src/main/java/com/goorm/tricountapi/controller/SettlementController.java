package com.goorm.tricountapi.controller;

import com.goorm.tricountapi.dto.BalanceResult;
import com.goorm.tricountapi.model.ApiResponse;
import com.goorm.tricountapi.model.Settlement;
import com.goorm.tricountapi.service.SettlementService;
import com.goorm.tricountapi.util.MemberContext;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SettlementController {
    private final SettlementService settlementService;

    @PostMapping("/settles/create")
    public ApiResponse<Settlement> createSettlement(@RequestParam String settlementName) {
        return new ApiResponse<Settlement>().ok(settlementService.createAndJoinSettlement(settlementName, MemberContext.getCurrentMember()));
    }

    @PostMapping("/settles/{id}/join")
    public ApiResponse joinSettlement(@PathVariable("id") Long settlementId) {
        settlementService.joinSettlement(settlementId, MemberContext.getCurrentMember().getId());
        return new ApiResponse<>().ok();
    }

    @GetMapping("/settles/{id}/balance")
    public ApiResponse<BalanceResult> getSettlementBalanceResult(@PathVariable("id") Long settlementId) {
        return new ApiResponse<BalanceResult>().ok(settlementService.getBalanceResult(settlementId));
    }

}
