package com.andhraempower.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonarDto {

    private Integer id;
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

    public DonarDto(String firstName, String lastName, String phoneNumber, String email, String address,  Double amount, String category) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.amount = amount;

    }

    public DonarDto(Integer id, String firstName, String lastName, String phoneNumber, String email, String address,
    Integer villageId, String villageName,
    Integer mandalId, String mandalName,
    Integer districtId, String districtName, String memoryOf, Double amount) {
        this.id = id;
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
        this.memoryOf = memoryOf;
        this.amount = amount;
       
    }

 }


