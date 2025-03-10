package com.andhraempower.repository;

import com.andhraempower.entity.ProjectBankDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectBankDetailsRepository extends JpaRepository<ProjectBankDetail, Long> {
}
