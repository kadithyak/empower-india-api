package com.andhraempower.dto;

import com.andhraempower.entity.Finance;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VillageProjectExpenseResponse {
    private Double totalExpenses;
    private Double totalFunds;
    private Double remainingBalance;
    private  List<Finance> transactions;
}
