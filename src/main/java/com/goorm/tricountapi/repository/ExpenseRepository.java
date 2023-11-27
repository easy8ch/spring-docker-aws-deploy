package com.goorm.tricountapi.repository;

import com.goorm.tricountapi.dto.ExpenseResult;
import com.goorm.tricountapi.model.Expense;

import java.util.List;

public interface ExpenseRepository {
    Expense save(Expense expense);
    List<ExpenseResult> findExpensesWithMemberBySettlementId(Long settlementId);
}
