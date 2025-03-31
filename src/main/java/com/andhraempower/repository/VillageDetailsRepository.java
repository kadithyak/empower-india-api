package com.andhraempower.repository;

import com.andhraempower.entity.VillageDemographics;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VillageDetailsRepository extends JpaRepository<VillageDemographics, Long> {

    VillageDemographics findByVillageId(Integer villageId);

    VillageDemographics findById(Integer id);

    @Query("SELECT v FROM VillageDemographics v WHERE v.villageId IN (" +
            "SELECT vlg.id FROM VillageLookup vlg WHERE vlg.mandalId IN (" +
            "SELECT m.id FROM MandalLookup m WHERE m.districtId = :districtId))")
    Page<VillageDemographics> findByDistrictId(@Param("districtId") Long districtId, Pageable pageable);

}
