package com.andhraempower.repository;

import com.andhraempower.entity.ProjectStatusTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectStatusTrackingRepository extends JpaRepository<ProjectStatusTracking, Long> {

    List<ProjectStatusTracking> findByProjectId(Long projectId);

}
