package com.andhraempower.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "village_project")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VillageProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_category_id", nullable = false)
    private CategoryLookup projectCategory;

    @ManyToOne
    @JoinColumn(name = "project_type", nullable = false)
    private ProjectTypeLookup projectTypeLookup;

    @Column(name = "location")
    private String location;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "project_estimation")
    private Double projectEstimation;

    @Column(name = "government_share")
    private Double governmentShare;

    @Column(name = "public_share")
    private Double publicShare;

    @Column(name = "is_new")
    private Boolean isNew;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "last_updated_by", nullable = false)
    private String lastUpdatedBy;

    @Column(name = "STATUS_CODE", nullable = false)
    private String statusCode;

    @ManyToOne
    @JoinColumn(name = "village_id", nullable = false)
    private VillageLookup village;

}
