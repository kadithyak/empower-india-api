package com.andhraempower.service;

import com.andhraempower.entity.Finance;
import com.andhraempower.repository.FinanceRepository;
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

    public  Finance addTransaction(Finance finance) {
        return financeRepository.save(finance);
    }

    public List<Finance> getTransaction() {
        return financeRepository.findAll();
    }
}
