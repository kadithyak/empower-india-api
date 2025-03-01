package com.andhraempower.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectResponseDto {
    private Long id;
    private String projectCategory;
    private Integer projectCategoryId;
    private String projectType;
    private Long projectTypeId;
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
    private String villageName;
    private int villageId;
    private String mandalName;
    private int mandalId;
    private String districtName;
    private int districtId;
    private String pinCode;
}
