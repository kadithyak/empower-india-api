package com.andhraempower.events;

import com.andhraempower.constants.ProjectWorkFlowStatus;
import com.andhraempower.constants.StatusEnum;
import com.andhraempower.entity.ProjectStatusTracking;
import com.andhraempower.entity.VillageProject;
import com.andhraempower.entity.VillageProjectDonar;
import com.andhraempower.repository.ProjectRepository;
import com.andhraempower.repository.ProjectStatusTrackingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.andhraempower.constants.ProjectWorkFlowStatus.*;

@Component
@Slf4j
public class StatusChangeEventListener {

    private final ProjectRepository projectRepository;

    private final ProjectStatusTrackingRepository projectStatusTrackingRepository;

    private static final List<ProjectWorkFlowStatus> EVENTS_TO_CHECK_FOR_PROJECT_PUBLISH = List.of(COMMITTEE_MEMBER_ADDED, ESTIMATION_ADDED, BANK_DETAILS_ADDED);
    private static final List<ProjectWorkFlowStatus> EVENTS_TO_CHECK_FOR_WORK_IN_PROGRESS = List.of(SPONSOR_ADDED);


    public StatusChangeEventListener(ProjectRepository projectRepository
            , ProjectStatusTrackingRepository projectStatusTrackingRepository) {
        this.projectRepository = projectRepository;
        this.projectStatusTrackingRepository = projectStatusTrackingRepository;
    }

    @EventListener
    public void onStatusChangeEvent(StatusChangeEvent statusChangeEvent) {
        log.debug("Listener receive event for {}", statusChangeEvent);
        projectStatusTrackingRepository.save(transform(statusChangeEvent));
        log.debug("Successfully saved event");
        StatusEnum eligibleProjectStatus = getEligibleProjectStatus(statusChangeEvent.getProjectWorkFlowStatus(), statusChangeEvent.getProjectId());
        updateProjectStatus(eligibleProjectStatus, statusChangeEvent.getProjectId());
    }



    private StatusEnum getEligibleProjectStatus(ProjectWorkFlowStatus projectWorkFlowStatus, Long projectId) {

        if(EVENTS_TO_CHECK_FOR_WORK_IN_PROGRESS.contains(projectWorkFlowStatus)) {
            return isEligibleForWIP(projectId) ? StatusEnum.WIP : null;
        }

        if(EVENTS_TO_CHECK_FOR_PROJECT_PUBLISH.contains(projectWorkFlowStatus)) {
            return isProjectReadyToPublish(projectId) ? StatusEnum.WFD : null;
        }

        return null;
    }

    private boolean isEligibleForWIP(Long projectId) {
        if(projectId != null) {
            Optional<VillageProject> villageProject = projectRepository.findById(projectId);
            if(villageProject.isPresent()) {
                VillageProject project = villageProject.get();
                if (project.getProjectEstimation() != null && project.getProjectEstimation() > 0) {
                    double totalAmountSponsered = project.getVillageProjectDonars().stream()
                            .mapToDouble(VillageProjectDonar::getAmount).sum();
                    return totalAmountSponsered >= project.getProjectEstimation();
                }
            }
        }
        return false;
    }

    private boolean isProjectReadyToPublish(Long projectId) {
        if(projectId != null) {
            List<ProjectStatusTracking> projectStatusTrackings = projectStatusTrackingRepository.findByProjectId(projectId);
            List<String> addedProjectStatusList = projectStatusTrackings.stream().map(ProjectStatusTracking::getStatus).toList();
            List<String> requiredStatuses = EVENTS_TO_CHECK_FOR_PROJECT_PUBLISH.stream().map(ProjectWorkFlowStatus::name).toList();
            return new HashSet<>(addedProjectStatusList).containsAll(requiredStatuses);
        }
        return false;
    }

    private ProjectStatusTracking transform(StatusChangeEvent statusChangeEvent) {
        ProjectStatusTracking projectStatusTracking = new ProjectStatusTracking();
        projectStatusTracking.setProjectId(statusChangeEvent.getProjectId());
        projectStatusTracking.setStatus(statusChangeEvent.getProjectWorkFlowStatus().name());
        projectStatusTracking.setCreatedBy(statusChangeEvent.getChangedBy());
        projectStatusTracking.setCreatedDate(statusChangeEvent.getChangedTime());
        return  projectStatusTracking;
    }

    private void updateProjectStatus(StatusEnum eligibleProjectStatus, Long projectId) {
        if(eligibleProjectStatus != null) {
            Optional<VillageProject> villageProject = projectRepository.findById(projectId);
            villageProject.ifPresent(project -> {
                project.setStatusCode(eligibleProjectStatus.name());
                projectRepository.save(project);
            });
        }
    }
}
