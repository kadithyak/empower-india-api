package com.andhraempower.service;

import com.andhraempower.entity.CommitteeMembers;
import com.andhraempower.repository.CommitteeMemberRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class CommitteeService {
    @Autowired
    private  CommitteeMemberRepository committeeMemberRepository;

    public CommitteeMembers addCommitteeMember(CommitteeMembers member) {
        return committeeMemberRepository.save(member);
    }

    public List<CommitteeMembers> getCommittee() {
        return committeeMemberRepository.findAll();
    }
}
