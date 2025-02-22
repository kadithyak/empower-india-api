package com.andhraempower.service;

import com.andhraempower.dto.VillageProjectExpenseResponse;
import com.andhraempower.entity.Finance;
import com.andhraempower.repository.FinanceRepository;
import com.andhraempower.repository.ProjectRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class FinanceService {

    @Autowired
    private FinanceRepository financeRepository;

    @Autowired
    private ProjectRepository villageProjectRepository;



    public  Finance addTransaction(Finance finance) {
        return financeRepository.save(finance);
    }

    public List<Finance> getTransaction() {
        return financeRepository.findAll();
    }

    public VillageProjectExpenseResponse getTransactionsForProject(Long projectId) {
        List<Finance> transactions = financeRepository.findByVillageProjectId(projectId);
        Double totalExpenses = transactions.stream().mapToDouble(Finance::getTransactionAmount).sum();
        Double totalFunds = villageProjectRepository.findById(projectId).map(p->p.getProjectEstimation()).orElse(0.0);
        Double remainingBalance = totalFunds - totalExpenses;
        VillageProjectExpenseResponse response = new VillageProjectExpenseResponse();
        response.setTotalExpenses(totalExpenses);
        response.setTotalFunds(totalFunds);
        response.setRemainingBalance(remainingBalance);
        response.setTransactions(transactions);
        return response;
    }

    @Transactional
    public void removeTransactionFromProject(Long transactionId, Long projectId) {
        financeRepository.deleteByIdAndVillageProjectId(transactionId, projectId);
    }
}
