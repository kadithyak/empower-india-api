package com.andhraempower.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectInfoDto {
    private Long donarId;
    private String memoryOf;
    private String modeOfPayment;
    private Double amount;
    private Long projectId;
    private String projectCategory;
    private String projectType;
    private String location;
    private Integer villageId;
    private String villageName;
    private Integer mandalId;
    private String mandalName;
    private Integer districtId;
    private String districtName;
}
