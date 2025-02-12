package com.andhraempower.repository;

import com.andhraempower.dto.ProjectResponseDto;
import com.andhraempower.entity.VillageProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<VillageProject, Long> {

    @Query("SELECT new com.andhraempower.dto.ProjectResponseDto( " +
            "vp.id, vp.villageProposalId, vp.projectCategory.name, vp.projectName, vp.status, vp.location, " +
            "vp.latitude, vp.longitude, vp.projectEstimation, vp.governmentShare, vp.publicShare, " +
            "vp.isNew, vp.description, vp.createdBy, vp.lastUpdatedBy, " +
            "vl.name, ml.name, dl.name) " +
            "FROM VillageProject vp " +
            "JOIN VillageProposal vpr ON vp.villageProposalId = vpr.id " +
            "JOIN VillageLookup vl ON vpr.villageId = vl.id " +
            "JOIN MandalLookup ml ON vl.mandalId = ml.id " +
            "JOIN DistrictLookup dl ON ml.districtId = dl.id")
    List<ProjectResponseDto> findAllProjects();
}