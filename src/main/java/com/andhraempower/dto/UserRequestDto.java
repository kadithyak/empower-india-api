package com.andhraempower.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String userName;
    private String password;
    private String aboutYourSelf;
    private List<RoleDto> roles;

}
