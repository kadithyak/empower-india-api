package com.andhraempower.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

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
    private Double remainingRequiredAmount;

    public ProjectResponseDto(Long id, String projectCategory, Integer projectCategoryId, String projectType
            , Long projectTypeId, String status, String location, Double latitude, Double longitude, Double projectEstimation
            , Double governmentShare, Double publicShare, Boolean isNew, String description, String createdBy
            , String lastUpdatedBy, String villageName, int villageId, String mandalName, int mandalId, String districtName
            , int districtId, String pinCode) {
        this.id = id;
        this.projectCategory = projectCategory;
        this.projectCategoryId = projectCategoryId;
        this.projectType = projectType;
        this.projectTypeId = projectTypeId;
        this.status = status;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.projectEstimation = projectEstimation;
        this.governmentShare = governmentShare;
        this.publicShare = publicShare;
        this.isNew = isNew;
        this.description = description;
        this.createdBy = createdBy;
        this.lastUpdatedBy = lastUpdatedBy;
        this.villageName = villageName;
        this.villageId = villageId;
        this.mandalName = mandalName;
        this.mandalId = mandalId;
        this.districtName = districtName;
        this.districtId = districtId;
        this.pinCode = pinCode;
    }

    public ProjectResponseDto(Long id, String projectCategory, Integer projectCategoryId, String projectType
            , Long projectTypeId, String status, String location, Double latitude, Double longitude
            , Double projectEstimation, Double governmentShare, Double publicShare, Boolean isNew
            , String description, String createdBy, String lastUpdatedBy, String villageName
            , int villageId, String mandalName, int mandalId, String districtName, int districtId, String pinCode, Double remainingRequiredAmount) {
        this.id = id;
        this.projectCategory = projectCategory;
        this.projectCategoryId = projectCategoryId;
        this.projectType = projectType;
        this.projectTypeId = projectTypeId;
        this.status = status;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.projectEstimation = projectEstimation;
        this.governmentShare = governmentShare;
        this.publicShare = publicShare;
        this.isNew = isNew;
        this.description = description;
        this.createdBy = createdBy;
        this.lastUpdatedBy = lastUpdatedBy;
        this.villageName = villageName;
        this.villageId = villageId;
        this.mandalName = mandalName;
        this.mandalId = mandalId;
        this.districtName = districtName;
        this.districtId = districtId;
        this.pinCode = pinCode;
        this.remainingRequiredAmount = remainingRequiredAmount;
    }
}
