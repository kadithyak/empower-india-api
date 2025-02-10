package com.andhraempower.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectResponseDto {
    private Long id;
    private Integer villageProposalId;
    private String projectCategory;
    private String projectName;
    private String status;
    private String location;
    private Double latitude;
    private Double longitude;
    private Double projectEstimation;
    private Double governmentShare;
    private Double publicShare;
    private Boolean isNew;
    private String description;
    private String createdBy;
    private String lastUpdatedBy;
}
