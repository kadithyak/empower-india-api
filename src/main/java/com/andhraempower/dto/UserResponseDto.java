package com.andhraempower.dto;

import com.andhraempower.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String email;

    private String aboutYourSelf;

    private List<RoleDto> roles;

    private byte[] profilePhoto;

    private Integer districtId;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.phoneNumber = user.getPhoneNumber();
        this.aboutYourSelf = user.getAboutYourSelf();
        this.email = user.getEmail();
        if (user.getRoles() != null && !user.getRoles().isEmpty()) {
            this.roles = user.getRoles().stream()
                    .map(RoleDto::new)
                    .collect(Collectors.toList());
        } else {
            this.roles = List.of();
        }
        this.profilePhoto = user.getProfilePhoto();
        this.districtId = user.getDistrictId();

    }

}
