package com.andhraempower.repository;

import com.andhraempower.entity.VillageProjectCommitteeMembers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VillageProjectComitteeMemberRepository extends JpaRepository<VillageProjectCommitteeMembers, Long> {

    List<VillageProjectCommitteeMembers> getByVillageProjectId(Long projectId);

    @Modifying
    @Query("DELETE FROM VillageProjectCommitteeMembers vpcm where vpcm.villageProjectId = :projectId AND vpcm.committeeMembers.id = :committeeId")
    void deleteByIdAndVillageProjectId(@Param("committeeId") Long id, @Param("projectId") Long villageProjectId);

}
