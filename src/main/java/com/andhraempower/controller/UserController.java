package com.andhraempower.controller;

import com.andhraempower.constants.EmpowerConstants;
import com.andhraempower.dto.UserRequestDto;
import com.andhraempower.dto.UserResponseDto;
import com.andhraempower.entity.User;
import com.andhraempower.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Create a new user without roles.")
    @PostMapping("/create")
    @ApiResponses(value = {
            @ApiResponse(responseCode = EmpowerConstants.SUCCESS_CODE, description = EmpowerConstants.SUCCESS_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.BAD_REQUEST_CODE, description = EmpowerConstants.BAD_REQUEST_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.UNAUTHORIZED_CODE, description = EmpowerConstants.UNAUTHORIZED_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.FORBIDDEN_CODE, description = EmpowerConstants.FORBIDDEN_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.RESOURCE_NOT_FOUND_CODE, description = EmpowerConstants.RESOURCE_NOT_FOUND_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.UNEXPECTED_SERVER_ERROR_CODE, description = EmpowerConstants.UNEXPECTED_SERVER_ERROR_CODE_DESC)
    })
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto) {
        User user = userService.createUser(userRequestDto);
        UserResponseDto response = new UserResponseDto(user);
        return ResponseEntity.ok(response);
    }
}
