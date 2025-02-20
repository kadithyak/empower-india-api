package com.andhraempower.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "village_project_committee_members")
public class VillageProjectCommitteeMembers extends Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "village_project_id")
    private Long villageProjectId;

    @OneToOne
    @JoinColumn(name = "committee_id")
    private CommitteeMembers committeeMembers;

}
