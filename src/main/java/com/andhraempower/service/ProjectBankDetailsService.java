package com.andhraempower.service;

import com.andhraempower.entity.ProjectBankDetail;
import com.andhraempower.events.StatusChangeEvent;
import com.andhraempower.events.StatusChangePublisher;
import com.andhraempower.repository.ProjectBankDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.andhraempower.constants.EmpowerConstants.USER_ADMIN;
import static com.andhraempower.constants.ProjectWorkFlowStatus.BANK_DETAILS_ADDED;

@Service
@AllArgsConstructor
public class ProjectBankDetailsService {

    private final ProjectBankDetailsRepository projectBankDetailsRepository;
    private final StatusChangePublisher statusChangePublisher;


    public ProjectBankDetail addBankDetails(ProjectBankDetail projectBankDetail) {
        if(projectBankDetail != null) {
            ProjectBankDetail bankDetail = projectBankDetailsRepository.save(projectBankDetail);
            statusChangePublisher.publishStatusChange(new StatusChangeEvent(projectBankDetail.getProjectId()
                    , BANK_DETAILS_ADDED, USER_ADMIN, LocalDateTime.now()));
            return bankDetail;
        } else {
            throw new IllegalArgumentException("Invalid input");
        }
    }

    public ProjectBankDetail updateProject(ProjectBankDetail projectBankDetail) {
        return projectBankDetailsRepository.save(projectBankDetail);
    }
}
