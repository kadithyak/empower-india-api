package com.andhraempower.service;

import com.andhraempower.entity.VillageDemographics;
import com.andhraempower.repository.VillageDetailsRepository;
import jakarta.persistence.EntityNotFoundException;
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


    public VillageDemographics updateVillageDetails(VillageDemographics updatedVillage) {

        VillageDemographics existingVillage = villageDetailsRepository.findById(updatedVillage.getId());

        if (existingVillage == null) {
            throw new EntityNotFoundException("Village not found with id: " + updatedVillage.getId());
        }
        if (updatedVillage.getNoOfHouses() != null) {
            existingVillage.setNoOfHouses(updatedVillage.getNoOfHouses());
        }

        if (updatedVillage.getTotalPopulation() != null) {
            existingVillage.setTotalPopulation(updatedVillage.getTotalPopulation());
        }

        if (updatedVillage.getAdultMalePopulation() != null) {
            existingVillage.setAdultMalePopulation(updatedVillage.getAdultMalePopulation());
        }
        if (updatedVillage.getAdultFemalePopulation() != null) {
            existingVillage.setAdultFemalePopulation(updatedVillage.getAdultFemalePopulation());
        }
        if (updatedVillage.getChildMalePopulation() != null) {
            existingVillage.setChildMalePopulation(updatedVillage.getChildMalePopulation());
        }
        if (updatedVillage.getChildFemalePopulation() != null) {
            existingVillage.setChildFemalePopulation(updatedVillage.getChildFemalePopulation());
        }

        if (updatedVillage.getScMale() != null) {
            existingVillage.setScMale(updatedVillage.getScMale());
        }
        if (updatedVillage.getScFemale() != null) {
            existingVillage.setScFemale(updatedVillage.getScFemale());
        }

        if (updatedVillage.getStMale() != null) {
            existingVillage.setStMale(updatedVillage.getStMale());
        }

        if (updatedVillage.getStFemale() != null) {
            existingVillage.setStFemale(updatedVillage.getStFemale());
        }

        if (updatedVillage.getBcMale() != null) {
            existingVillage.setBcMale(updatedVillage.getBcMale());
        }

        if (updatedVillage.getBcFemale() != null) {
            existingVillage.setBcFemale(updatedVillage.getBcFemale());
        }


        if (updatedVillage.getOcMale() != null) {
            existingVillage.setOcMale(updatedVillage.getOcMale());
        }

        if (updatedVillage.getOcFemale() != null) {
            existingVillage.setOcFemale(updatedVillage.getOcFemale());
        }


        if (updatedVillage.getOtherMale() != null) {
            existingVillage.setOtherMale(updatedVillage.getOtherMale());
        }

        if (updatedVillage.getOtherFemale() != null) {
            existingVillage.setOtherFemale(updatedVillage.getOtherFemale());
        }

        if (updatedVillage.getArea() != null) {
            existingVillage.setArea(updatedVillage.getArea());
        }

        if (updatedVillage.getLatitude() != null) {
            existingVillage.setLatitude(updatedVillage.getLatitude());
        }

        if (updatedVillage.getLongitude() != null) {
            existingVillage.setLongitude(updatedVillage.getLongitude());
        }

        if (updatedVillage.getPopulations() != null && !updatedVillage.getPopulations().isEmpty()) {
            existingVillage.getPopulations().addAll(updatedVillage.getPopulations());
        }

        if (updatedVillage.getUnEmployedYouthVillage() != null && !updatedVillage.getUnEmployedYouthVillage().isEmpty()) {
            existingVillage.getUnEmployedYouthVillage().addAll(updatedVillage.getUnEmployedYouthVillage());
        }

        if (updatedVillage.getEmployedYouthVillage() != null && !updatedVillage.getEmployedYouthVillage().isEmpty()) {
            existingVillage.getEmployedYouthVillage().addAll(updatedVillage.getEmployedYouthVillage());
        }

        if (updatedVillage.getOccupations() != null && !updatedVillage.getOccupations().isEmpty()) {
            existingVillage.getOccupations().addAll(updatedVillage.getOccupations());
        }

        if (updatedVillage.getLandUtilizationVillage() != null && !updatedVillage.getLandUtilizationVillage().isEmpty()) {
            existingVillage.getLandUtilizationVillage().addAll(updatedVillage.getLandUtilizationVillage());
        }

        if (updatedVillage.getCultivationCropsVillage() != null && !updatedVillage.getCultivationCropsVillage().isEmpty()) {
            existingVillage.getCultivationCropsVillage().addAll(updatedVillage.getCultivationCropsVillage());
        }

        if (updatedVillage.getLiveStockVillages() != null && !updatedVillage.getLiveStockVillages().isEmpty()) {
            existingVillage.getLiveStockVillages().addAll(updatedVillage.getLiveStockVillages());
        }

        if (updatedVillage.getInstitutionsVillages() != null && !updatedVillage.getInstitutionsVillages().isEmpty()) {
            existingVillage.getInstitutionsVillages().addAll(updatedVillage.getInstitutionsVillages());
        }

        return villageDetailsRepository.save(existingVillage);
    }
}
