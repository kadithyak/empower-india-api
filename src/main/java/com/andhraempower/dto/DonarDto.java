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
    private Double amount;
    private String category;
}


