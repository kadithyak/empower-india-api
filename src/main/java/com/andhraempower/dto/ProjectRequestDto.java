package com.andhraempower.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectRequestDto {
    private String district;
    private String mandal;
    private String village;
    private String location;
    private Double latitude;
    private Double longitude;
    private String projectCategory;
    private String projectName;
    private String projectNeed;
    private Double projectEstimation;
    private Double governmentShare;
    private Double publicShare;
    private String description;
}
