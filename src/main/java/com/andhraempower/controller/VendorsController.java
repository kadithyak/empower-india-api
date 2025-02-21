package com.andhraempower.controller;

import com.andhraempower.constants.EmpowerConstants;
import com.andhraempower.entity.Vendors;
import com.andhraempower.service.VendorsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/vendors")
@RequiredArgsConstructor
@Slf4j
public class VendorsController {

    @Autowired
    private VendorsService VendorsService;

    @GetMapping(produces = {EmpowerConstants.APPLICATION_JSON, EmpowerConstants.TEXT_PLAIN})
    @Operation(summary = "Fetches Vendors.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = EmpowerConstants.SUCCESS_CODE, description = EmpowerConstants.SUCCESS_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.BAD_REQUEST_CODE, description = EmpowerConstants.BAD_REQUEST_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.UNAUTHORIZED_CODE, description = EmpowerConstants.UNAUTHORIZED_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.FORBIDDEN_CODE, description = EmpowerConstants.FORBIDDEN_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.RESOURCE_NOT_FOUND_CODE, description = EmpowerConstants.RESOURCE_NOT_FOUND_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.UNEXPECTED_SERVER_ERROR_CODE, description = EmpowerConstants.UNEXPECTED_SERVER_ERROR_CODE_DESC)
    })
    public List<Vendors> getVendors(@RequestParam(value = "projectId", required = false) Long projectId){
        return VendorsService.getVendors();
    }


    @PostMapping(produces = {EmpowerConstants.APPLICATION_JSON, EmpowerConstants.TEXT_PLAIN})
    @Operation(summary = "Adds new Vendors .")
    @ApiResponses(value = {
            @ApiResponse(responseCode = EmpowerConstants.SUCCESS_CODE, description = EmpowerConstants.SUCCESS_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.BAD_REQUEST_CODE, description = EmpowerConstants.BAD_REQUEST_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.UNAUTHORIZED_CODE, description = EmpowerConstants.UNAUTHORIZED_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.FORBIDDEN_CODE, description = EmpowerConstants.FORBIDDEN_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.RESOURCE_NOT_FOUND_CODE, description = EmpowerConstants.RESOURCE_NOT_FOUND_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.UNEXPECTED_SERVER_ERROR_CODE, description = EmpowerConstants.UNEXPECTED_SERVER_ERROR_CODE_DESC)
    })
    public Vendors addVendors(@RequestParam(value = "projectId", required = false) Long projectId, @RequestBody Vendors vendors) {
        return VendorsService.addVendors(vendors);
    }
}
