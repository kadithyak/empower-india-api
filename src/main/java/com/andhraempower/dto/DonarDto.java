package com.andhraempower.dto;
import com.andhraempower.entity.Donar;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DonarDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;
    private Double amount;
    private String category;
    private Integer villageId;
    private String villageName;
    private Integer mandalId;
    private String mandalName;
    private Integer districtId;
    private String districtName;
    private String memoryOf;
    private String modeOfPayment;
  
    public DonarDto(String firstName, String lastName, String phoneNumber, String email, 
    String address,  
    Integer villageId, String villageName,
    Integer mandalId, String mandalName,
    Integer districtId, String districtName,
    Double amount, String category) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.villageId = villageId;
        this.villageName = villageName;
        this.mandalId = mandalId;
        this.mandalName = mandalName;
        this.districtId = districtId;
        this.districtName = districtName;
        this.amount = amount;
        this.category = category;

    }

    public Donar fromDto(){
        Donar donar = new Donar();
        donar.setId(this.id);
        donar.setFirstName(this.firstName);
        donar.setLastName(this.lastName);
        donar.setPhoneNumber(this.phoneNumber);
        donar.setEmail(this.email);
        donar.setAddress(this.address);
        donar.setMemoryOf(this.memoryOf);
        return donar;
    }

}


