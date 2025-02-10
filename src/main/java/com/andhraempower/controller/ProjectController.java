package com.andhraempower.controller;

import com.andhraempower.constants.EmpowerConstants;
import com.andhraempower.dto.ProjectRequestDto;
import com.andhraempower.dto.ProjectResponseDto;
import com.andhraempower.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    /**
     * GET API - Fetch all projects
     */
    @GetMapping(value = "/getProjects", produces = {EmpowerConstants.APPLICATION_JSON, EmpowerConstants.TEXT_PLAIN})
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
        List<ProjectResponseDto> projects = projectService.getProjects();
        return ResponseEntity.ok(projects);
    }

    @PostMapping(value = "/saveProject", consumes = EmpowerConstants.APPLICATION_JSON, produces = EmpowerConstants.TEXT_PLAIN)
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
        projectService.saveProject(projectRequestDto);
        return ResponseEntity.ok("New project saved successfully!");
    }
}
