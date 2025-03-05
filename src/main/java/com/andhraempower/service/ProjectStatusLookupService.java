package com.andhraempower.service;

import com.andhraempower.entity.ProjectStatusLookup;
import com.andhraempower.repository.ProjectStatusLookupRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
@Slf4j
public class ProjectStatusLookupService {

    @Autowired
    private ProjectStatusLookupRepository projectStatusLookupRepository;
    public List<ProjectStatusLookup> getProjectStatus() {
        return projectStatusLookupRepository.findAll();
    }
}
