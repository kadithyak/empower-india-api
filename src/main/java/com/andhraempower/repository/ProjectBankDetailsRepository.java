package com.andhraempower.repository;

import com.andhraempower.entity.ProjectBankDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectBankDetailsRepository extends JpaRepository<ProjectBankDetail, Long> {

    List<ProjectBankDetail> findByProjectId(Long projectId);
}
