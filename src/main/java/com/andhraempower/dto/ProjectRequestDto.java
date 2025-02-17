package com.andhraempower.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProjectRequestDto {
    private Long id;
    private Integer districtId;
    private Integer mandalId;
    private Integer villageId;
    private String location;
    private Double latitude;
    private Double longitude;
    private Integer projectCategoryId;
    private String projectType;
    private String projectNeed;
    private Double projectEstimation;
    private Double governmentShare;
    private Double publicShare;
    private String description;
    private String statusCode;
}
