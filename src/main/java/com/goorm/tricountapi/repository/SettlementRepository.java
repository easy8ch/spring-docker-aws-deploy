package com.goorm.tricountapi.repository;

import com.goorm.tricountapi.model.Settlement;

import java.util.Optional;

public interface SettlementRepository {
    Settlement create(String name);
    void addParticipantToSettlement(Long settlementId, Long memberId);
    Optional<Settlement> findById(Long id);
}
