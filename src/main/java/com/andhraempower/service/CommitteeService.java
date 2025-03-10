package com.andhraempower.service;

import com.andhraempower.constants.ProjectWorkFlowStatus;
import com.andhraempower.entity.CommitteeMembers;
import com.andhraempower.entity.VillageProjectCommitteeMembers;
import com.andhraempower.events.StatusChangeEvent;
import com.andhraempower.events.StatusChangePublisher;
import com.andhraempower.repository.CommitteeMemberRepository;
import com.andhraempower.repository.VillageProjectComitteeMemberRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.andhraempower.constants.EmpowerConstants.USER_ADMIN;
import static com.andhraempower.constants.ProjectWorkFlowStatus.COMMITTEE_MEMBER_ADDED;

@AllArgsConstructor
@Service
@Slf4j
public class CommitteeService {
    @Autowired
    private  CommitteeMemberRepository committeeMemberRepository;
    @Autowired
    private VillageProjectComitteeMemberRepository villageProjectComitteeMemberRepository;

    private StatusChangePublisher statusChangePublisher;

    public CommitteeMembers addCommitteeMember(CommitteeMembers member) {
        return committeeMemberRepository.save(member);
    }

    public void associateComitteMemberToProject(Long projectId, CommitteeMembers member){
        Optional.ofNullable(projectId).ifPresent(id -> {
            VillageProjectCommitteeMembers villageProjectCommitteeMembers = new VillageProjectCommitteeMembers();
            villageProjectCommitteeMembers.setCommitteeMembers(member);
            villageProjectCommitteeMembers.setVillageProjectId(projectId);
            villageProjectCommitteeMembers.setCreatedBy(USER_ADMIN);
            villageProjectComitteeMemberRepository.save(villageProjectCommitteeMembers);
            statusChangePublisher.publishStatusChange(new StatusChangeEvent(projectId, COMMITTEE_MEMBER_ADDED, USER_ADMIN, LocalDateTime.now()));
        });
    }

    public List<CommitteeMembers> getCommittee(Long projectId) {
        return Optional.ofNullable(projectId)
                .map(id -> {
                    List<VillageProjectCommitteeMembers> byVillageProjectId = villageProjectComitteeMemberRepository.getByVillageProjectId(id);
                    if(byVillageProjectId != null && !byVillageProjectId.isEmpty()){
                        return byVillageProjectId.stream().map(VillageProjectCommitteeMembers::getCommitteeMembers).collect(Collectors.toList());
                    }
                    return new ArrayList<CommitteeMembers>();
                }).orElse(committeeMemberRepository.findAll());
    }

    @Transactional
    public void removeCommitteeMemberFromProject(Long committeeId, Long projectId){
        villageProjectComitteeMemberRepository.deleteByIdAndVillageProjectId(committeeId, projectId);
    }


}
