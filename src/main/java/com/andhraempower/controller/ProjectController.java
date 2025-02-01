package com.andhraempower.controller;

import com.andhraempower.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Projects")
@RequiredArgsConstructor
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping("/getProjects")
    public String getProjects(){
        return projectService.getProjectDetails();
    }

}
