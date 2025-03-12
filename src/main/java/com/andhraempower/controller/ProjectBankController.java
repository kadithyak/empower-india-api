package com.andhraempower.controller;


import com.andhraempower.constants.EmpowerConstants;
import com.andhraempower.entity.Donar;
import com.andhraempower.entity.ProjectBankDetail;
import com.andhraempower.service.ProjectBankDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/bank")
@RequiredArgsConstructor
@Slf4j
public class ProjectBankController {

    private final ProjectBankDetailsService projectBankDetailsService;

    @PostMapping
    @Operation(summary = "Add Bank details to project")
    @ApiResponses(value = {
            @ApiResponse(responseCode = EmpowerConstants.SUCCESS_CODE, description = EmpowerConstants.SUCCESS_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.BAD_REQUEST_CODE, description = EmpowerConstants.BAD_REQUEST_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.UNAUTHORIZED_CODE, description = EmpowerConstants.UNAUTHORIZED_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.FORBIDDEN_CODE, description = EmpowerConstants.FORBIDDEN_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.RESOURCE_NOT_FOUND_CODE, description = EmpowerConstants.RESOURCE_NOT_FOUND_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.UNEXPECTED_SERVER_ERROR_CODE, description = EmpowerConstants.UNEXPECTED_SERVER_ERROR_CODE_DESC)
    })
    public ResponseEntity<ProjectBankDetail> addBankDetails(@RequestBody ProjectBankDetail projectBankDetail) {
        log.debug("Adding bank to details to project {}", projectBankDetail);
        try {
            return ResponseEntity.ok(projectBankDetailsService.addBankDetails(projectBankDetail));
        }catch (IllegalArgumentException e) {
            log.error("Invalid input", e);
            return ResponseEntity.badRequest().build();
        } catch (Exception e){
            log.error("Exception while adding committee member", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping(produces = {EmpowerConstants.APPLICATION_JSON, EmpowerConstants.TEXT_PLAIN})
    @Operation(summary = "Update Donar details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = EmpowerConstants.SUCCESS_CODE, description = EmpowerConstants.SUCCESS_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.BAD_REQUEST_CODE, description = EmpowerConstants.BAD_REQUEST_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.UNAUTHORIZED_CODE, description = EmpowerConstants.UNAUTHORIZED_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.FORBIDDEN_CODE, description = EmpowerConstants.FORBIDDEN_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.RESOURCE_NOT_FOUND_CODE, description = EmpowerConstants.RESOURCE_NOT_FOUND_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.UNEXPECTED_SERVER_ERROR_CODE, description = EmpowerConstants.UNEXPECTED_SERVER_ERROR_CODE_DESC)
    })
    public ResponseEntity<ProjectBankDetail> updateBankDetails( @RequestBody ProjectBankDetail projectBankDetail) {
        log.debug("update  bank details for project Id {}", projectBankDetail.getProjectId());
        try {
            if(projectBankDetail.getId() == null || projectBankDetail.getProjectId() == null){
                return ResponseEntity.badRequest().build();
            }
            ProjectBankDetail bankDetails = projectBankDetailsService.updateProject(projectBankDetail);
            return ResponseEntity.ok().body(bankDetails);
        }catch (Exception e){
            log.error("Exception while adding donar", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(value = "/{projectId}",produces = {EmpowerConstants.APPLICATION_JSON, EmpowerConstants.TEXT_PLAIN})
    @Operation(summary = "Displays BankDetails.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = EmpowerConstants.SUCCESS_CODE, description = EmpowerConstants.SUCCESS_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.BAD_REQUEST_CODE, description = EmpowerConstants.BAD_REQUEST_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.UNAUTHORIZED_CODE, description = EmpowerConstants.UNAUTHORIZED_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.FORBIDDEN_CODE, description = EmpowerConstants.FORBIDDEN_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.RESOURCE_NOT_FOUND_CODE, description = EmpowerConstants.RESOURCE_NOT_FOUND_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.UNEXPECTED_SERVER_ERROR_CODE, description = EmpowerConstants.UNEXPECTED_SERVER_ERROR_CODE_DESC)
    })
    public List<ProjectBankDetail> getBankDetails(@PathVariable(value = "projectId") Long projectId) {
        return projectBankDetailsService.getProjectBankDetails(projectId);
    }


}
