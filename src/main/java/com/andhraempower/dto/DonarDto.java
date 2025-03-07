package com.andhraempower.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonarDto {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;
    private Double amount;
    private String category;

    public DonarDto(String firstName, String lastName, String phoneNumber, String email, String address, Double amount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.amount = amount;

    }
}


