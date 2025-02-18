package com.andhraempower.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.andhraempower.entity.Finance;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanceRepository extends JpaRepository<Finance, Long> {
}
