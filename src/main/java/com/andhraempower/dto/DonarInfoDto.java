package com.andhraempower.dto;
import com.andhraempower.entity.Donar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonarInfoDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String memoryOf;
    private String modeOfPayment;
    private Double amount;
    private ProjectInfo projectInfo;
   
    public DonarInfoDto(Long id, String firstName, String lastName, String phoneNumber, String email, 
    String memoryOf, String modeOfPayment, Double amount,
    Long projectId,  String projectCategory, String projectType, 
    String location,  
    Integer villageId, String villageName,
    Integer mandalId, String mandalName,
    Integer districtId, String districtName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.memoryOf = memoryOf;
        this.modeOfPayment = modeOfPayment;
        this.amount = amount;
        this.projectInfo = new ProjectInfo(projectId, projectCategory, projectType, location, villageId, villageName, mandalId, mandalName, districtId, districtName);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProjectInfo {
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
}


