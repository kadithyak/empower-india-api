package com.andhraempower.events;

import com.andhraempower.constants.ProjectWorkFlowStatus;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

import static com.andhraempower.constants.EmpowerConstants.PROJECT_FLOW;


public class StatusChangeEvent extends ApplicationEvent {

    private Long projectId;
    private ProjectWorkFlowStatus projectWorkFlowStatus;
    private String changedBy;
    private LocalDateTime changedTime;

    public StatusChangeEvent(Object source, Long projectId, ProjectWorkFlowStatus projectWorkFlowStatus, String changedBy, LocalDateTime changedTime) {
        super(source);
        this.projectId = projectId;
        this.projectWorkFlowStatus = projectWorkFlowStatus;
        this.changedBy = changedBy;
        this.changedTime = changedTime;
    }

    public StatusChangeEvent(Long projectId, ProjectWorkFlowStatus projectWorkFlowStatus, String changedBy, LocalDateTime changedTime){
        super(PROJECT_FLOW);
        this.projectId = projectId;
        this.projectWorkFlowStatus = projectWorkFlowStatus;
        this.changedBy = changedBy;
        this.changedTime = changedTime;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public ProjectWorkFlowStatus getProjectWorkFlowStatus() {
        return projectWorkFlowStatus;
    }

    public void setProjectWorkFlowStatus(ProjectWorkFlowStatus projectWorkFlowStatus) {
        this.projectWorkFlowStatus = projectWorkFlowStatus;
    }

    public String getChangedBy() {
        return changedBy;
    }

    public void setChangedBy(String changedBy) {
        this.changedBy = changedBy;
    }

    public LocalDateTime getChangedTime() {
        return changedTime;
    }

    public void setChangedTime(LocalDateTime changedTime) {
        this.changedTime = changedTime;
    }

    @Override
    public String toString() {
        return "StatusChangeEvent{" +
                "projectId=" + projectId +
                ", projectWorkFlowStatus=" + projectWorkFlowStatus +
                ", changedBy='" + changedBy + '\'' +
                ", changedTime=" + changedTime +
                '}';
    }
}
