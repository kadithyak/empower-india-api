package com.andhraempower.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

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
    private List<DonarDto> sponsersList;
    private boolean isCommitteeAdded;
    private boolean isBankDetailsAdded;
    private boolean isEstimationAdded;
    private LocalDate estimateStartDate;
    private LocalDate estimateEndDate;
    private LocalDate actualStartDate;
    private LocalDate actualEndDate;
    private String statusCode;

    public ProjectResponseDto(Long id, String projectCategory, Integer projectCategoryId, String projectType
            , Long projectTypeId, String status, String location, Double latitude, Double longitude, Double projectEstimation
            , Double governmentShare, Double publicShare, Boolean isNew, String description, String createdBy
            , String lastUpdatedBy, String villageName, int villageId, String mandalName, int mandalId, String districtName
            , int districtId, String pinCode, boolean isCommitteeAdded, boolean isBankDetailsAdded, boolean isEstimationAdded,LocalDate estimateStartDate,
             LocalDate estimateEndDate, LocalDate actualStartDate, LocalDate actualEndDate,String statusCode
    ) {
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
        this.isCommitteeAdded = isCommitteeAdded;
        this.isBankDetailsAdded = isBankDetailsAdded;
        this.isEstimationAdded = isEstimationAdded;
        this.estimateEndDate = estimateEndDate;
        this.estimateStartDate = estimateStartDate;
        this.actualStartDate = actualStartDate;
        this.actualEndDate = actualEndDate;
        this.statusCode = statusCode;
    }

    public ProjectResponseDto(Long id, String projectCategory, Integer projectCategoryId, String projectType
            , Long projectTypeId, String status, String location, Double latitude, Double longitude
            , Double projectEstimation, Double governmentShare, Double publicShare, Boolean isNew
            , String description, String createdBy, String lastUpdatedBy, String villageName
            , int villageId, String mandalName, int mandalId, String districtName, int districtId, String pinCode, Double remainingRequiredAmount
            ,LocalDate estimateStartDate, LocalDate estimateEndDate, LocalDate actualStartDate, LocalDate actualEndDate,String statusCode) {
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
        this.estimateEndDate = estimateEndDate;
        this.estimateStartDate = estimateStartDate;
        this.actualStartDate = actualStartDate;
        this.actualEndDate = actualEndDate;
        this.statusCode = statusCode;
    }
}
