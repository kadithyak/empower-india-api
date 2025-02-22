package com.andhraempower.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.andhraempower.entity.Finance;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinanceRepository extends JpaRepository<Finance, Long> {
    List<Finance> findByVillageProjectId(Long projectId);




    void deleteByIdAndVillageProjectId(Long transactionId, Long projectId);
}

