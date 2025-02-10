package com.andhraempower.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "village_proposal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VillageProposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "village_id", nullable = false)
    private Integer villageId;

    @Column(name = "facility_id", nullable = false)
    private Integer facilityId;

    @Column(name = "status", nullable = true)
    private String status;

    @Column(name = "created_date", nullable = true)
    private LocalDateTime createdDate;

    @Column(name = "created_by", nullable = true)
    private String createdBy;

    @Column(name = "last_updated_date", nullable = true)
    private LocalDateTime lastUpdatedDate;

    @Column(name = "last_updated_by", nullable = true)
    private String lastUpdatedBy;
}
