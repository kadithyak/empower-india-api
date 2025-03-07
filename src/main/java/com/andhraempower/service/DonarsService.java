package com.andhraempower.service;

import com.andhraempower.dao.LookupDAO;
import com.andhraempower.dto.DonarDto;
import com.andhraempower.entity.*;
import com.andhraempower.repository.DonarInfoRepository;
import com.andhraempower.repository.DonarsRepository;
import com.andhraempower.repository.VillageProjectDonarRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;

import static com.andhraempower.constants.EmpowerConstants.USER_ADMIN;

@AllArgsConstructor
@Service
@Slf4j
public class DonarsService {

    @Autowired
    private DonarsRepository donarsRepository;
    
    @Autowired
    private DonarInfoRepository donarInfoRepository;

    @Autowired
    private LookupDAO lookupDAO;

    private VillageProjectDonarRepository villageProjectDonarRepository;

    public Donar addDonars(DonarDto donars) {
        Donar donar = donars.fromDto();
        if(donars.getVillageId() != null && donars.getVillageId() > 0 ) {
            Optional<VillageLookup> villageById = lookupDAO.getVillageById(donars.getVillageId().intValue());
            villageById.ifPresent(donar::setVillage);
        }
        return donarsRepository.save(donar);
    }

    public void associateDonarToProject(Long projectId, Donar donar, Double amount, String modeOfPayment){
        Optional.ofNullable(projectId).ifPresent(id -> {
            VillageProjectDonar villageProjectDonar = new VillageProjectDonar();
            villageProjectDonar.setDonar(donar);
            villageProjectDonar.setVillageProjectId(projectId);
            villageProjectDonar.setAmount(amount);
            villageProjectDonar.setModeOfPayment(modeOfPayment);
            villageProjectDonar.setCreatedBy(USER_ADMIN);
            villageProjectDonarRepository.save(villageProjectDonar);
        });
    }

    public List<Donar> getDonars(Long projectId) {
        return Optional.ofNullable(projectId)
                .map(id -> {
                    List<VillageProjectDonar> byVillageProjectId = villageProjectDonarRepository.getByVillageProjectId(id);
                    if(byVillageProjectId != null && !byVillageProjectId.isEmpty()){
                        return byVillageProjectId.stream().map(VillageProjectDonar::getDonar).collect(Collectors.toList());
                    }
                    return new ArrayList<Donar>();
                }).orElse(donarsRepository.findAll());
    }

    @Transactional
    public void removeCommitteeMemberFromProject(Long committeeId, Long projectId){
        villageProjectDonarRepository.deleteByIdAndVillageProjectId(committeeId, projectId);
    }

    public List<DonarDto> getTopDonars(Integer topN) {
        int pageSize = (int) topN;  // Convert long to int safely
        Pageable pageable = PageRequest.of(0, pageSize); 
        //return donarInfoRepository.findTopDonars(pageable);
        return null;
    }
}
