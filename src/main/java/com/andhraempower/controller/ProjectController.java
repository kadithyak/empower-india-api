package com.andhraempower.controller;

import com.andhraempower.constants.EmpowerConstants;
import com.andhraempower.dto.ProjectRequestDto;
import com.andhraempower.dto.ProjectResponseDto;
import com.andhraempower.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/v1/project")
@RequiredArgsConstructor
@Slf4j
public class ProjectController {

    @Autowired
    private  ProjectService projectService;

    /**
     * GET API - Fetch all projects
     */
    @GetMapping(produces = {EmpowerConstants.APPLICATION_JSON, EmpowerConstants.TEXT_PLAIN})
    @Operation(summary = "Retrieves a list of all projects.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = EmpowerConstants.SUCCESS_CODE, description = EmpowerConstants.SUCCESS_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.BAD_REQUEST_CODE, description = EmpowerConstants.BAD_REQUEST_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.UNAUTHORIZED_CODE, description = EmpowerConstants.UNAUTHORIZED_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.FORBIDDEN_CODE, description = EmpowerConstants.FORBIDDEN_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.RESOURCE_NOT_FOUND_CODE, description = EmpowerConstants.RESOURCE_NOT_FOUND_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.UNEXPECTED_SERVER_ERROR_CODE, description = EmpowerConstants.UNEXPECTED_SERVER_ERROR_CODE_DESC)
    })
    public ResponseEntity<List<ProjectResponseDto>> getProjects() {
        try {
            List<ProjectResponseDto> projects = projectService.getProjects();
            log.debug("Projects List {}", projects);
            return ResponseEntity.ok(projects);
        }catch (Exception e){
            log.error("Exception while fetching the projects", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping(consumes = EmpowerConstants.APPLICATION_JSON, produces = EmpowerConstants.TEXT_PLAIN)
    @Operation(summary = "Saves a new project to the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = EmpowerConstants.SUCCESS_CODE, description = "Project saved successfully"),
            @ApiResponse(responseCode = EmpowerConstants.BAD_REQUEST_CODE, description = "Invalid request data"),
            @ApiResponse(responseCode = EmpowerConstants.UNAUTHORIZED_CODE, description = EmpowerConstants.UNAUTHORIZED_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.FORBIDDEN_CODE, description = EmpowerConstants.FORBIDDEN_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.RESOURCE_NOT_FOUND_CODE, description = EmpowerConstants.RESOURCE_NOT_FOUND_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.UNEXPECTED_SERVER_ERROR_CODE, description = "Server error while saving project")
    })
    public ResponseEntity<String> saveProject(@RequestBody ProjectRequestDto projectRequestDto) {
        try {
            log.debug("Request for saving project : {}", projectRequestDto);
            projectService.saveProject(projectRequestDto);
            return ResponseEntity.ok("New project saved successfully!");
        }catch (Exception e){
            log.error("Exception while saving the project", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping(consumes = EmpowerConstants.APPLICATION_JSON, produces = EmpowerConstants.TEXT_PLAIN)
    @Operation(summary = "updates existing project to the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = EmpowerConstants.SUCCESS_CODE, description = "Project Updated successfully"),
            @ApiResponse(responseCode = EmpowerConstants.BAD_REQUEST_CODE, description = "Invalid request data"),
            @ApiResponse(responseCode = EmpowerConstants.UNAUTHORIZED_CODE, description = EmpowerConstants.UNAUTHORIZED_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.FORBIDDEN_CODE, description = EmpowerConstants.FORBIDDEN_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.RESOURCE_NOT_FOUND_CODE, description = EmpowerConstants.RESOURCE_NOT_FOUND_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.UNEXPECTED_SERVER_ERROR_CODE, description = "Server error while saving project")
    })
    public ResponseEntity<String> updateProject(@RequestBody ProjectRequestDto projectRequestDto) {
        try {
            log.debug("Request for updating project : {}", projectRequestDto);
            projectService.updateProject(projectRequestDto);
            return ResponseEntity.ok("Project updates successfully!");
        }catch (Exception e){
            log.error("Exception while updating the project", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(value = "/search", produces = {EmpowerConstants.APPLICATION_JSON, EmpowerConstants.TEXT_PLAIN})
    @Operation(summary = "Retrieves a list of all projects.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = EmpowerConstants.SUCCESS_CODE, description = EmpowerConstants.SUCCESS_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.BAD_REQUEST_CODE, description = EmpowerConstants.BAD_REQUEST_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.UNAUTHORIZED_CODE, description = EmpowerConstants.UNAUTHORIZED_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.FORBIDDEN_CODE, description = EmpowerConstants.FORBIDDEN_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.RESOURCE_NOT_FOUND_CODE, description = EmpowerConstants.RESOURCE_NOT_FOUND_CODE_DESC),
            @ApiResponse(responseCode = EmpowerConstants.UNEXPECTED_SERVER_ERROR_CODE, description = EmpowerConstants.UNEXPECTED_SERVER_ERROR_CODE_DESC)
    })
    public ResponseEntity<List<ProjectResponseDto>> searchProjects(@RequestParam(name = "districtId") Long districtCode
            , @RequestParam(name = "mandalId", required = false) Long mandalCode, @RequestParam(name = "villageId", required = false) Long villageCode) {
        try {
            log.debug("Request received for search project districtId : {}, mandalId : {}, villageId : {}", districtCode, mandalCode, villageCode);
            List<ProjectResponseDto> projects = projectService.searchProjectsByDistrictMandalVillageCode(districtCode, mandalCode, villageCode);
            return ResponseEntity.ok(projects);
        }catch (Exception e){
            log.error("Error while searching projects", e);
            return ResponseEntity.internalServerError().build();
        }
    }


}
