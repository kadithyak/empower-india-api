package com.andhraempower.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProjectRequestDto {
    private Long id;
    @NonNull
    private Integer districtId;
    @NonNull
    private Integer mandalId;
    @NonNull
    private Integer villageId;
    private String location;
    private Double latitude;
    private Double longitude;
    @NonNull
    private Integer projectCategoryId;
    @NonNull
    private String projectType;
    private String projectNeed;
    private Double projectEstimation;
    private Double governmentShare;
    private Double publicShare;
    private String description;
    private String statusCode;
    private LocalDate estimateStartDate;
    private LocalDate estimateEndDate;
    private LocalDate actualStartDate;
    private LocalDate actualEndDate;
}
