package com.andhraempower.repository;

import com.andhraempower.entity.CommitteeMembers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommitteeMemberRepository extends JpaRepository<CommitteeMembers, Long> {
}
