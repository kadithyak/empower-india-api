package com.andhraempower.service;

import com.andhraempower.entity.VillageDemographics;
import com.andhraempower.repository.VillageDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VillageDetailsService {

    @Autowired
    private VillageDetailsRepository villageDetailsRepository;

    public VillageDemographics getVillageDetails(Integer villageId) {
        return villageDetailsRepository.findByVillageId(villageId);
    }

    public VillageDemographics addVillageDetails(VillageDemographics villageDemographics) {

        return villageDetailsRepository.save(villageDemographics);
    }
}
