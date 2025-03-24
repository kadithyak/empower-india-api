package com.andhraempower.repository;

import com.andhraempower.entity.VillageDemographics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VillageDetailsRepository extends JpaRepository<VillageDemographics, Long> {

    VillageDemographics findByVillageId(Integer villageId);

    VillageDemographics findById(Integer id);

}
