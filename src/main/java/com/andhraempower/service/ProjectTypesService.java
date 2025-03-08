package com.andhraempower.service;

import com.andhraempower.entity.ProjectTypeLookup;
import com.andhraempower.repository.ProjectTypeLookupRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
@Slf4j
public class ProjectTypesService {
    @Autowired
    private ProjectTypeLookupRepository projectTypeLookupRepository;
    public List<ProjectTypeLookup> getAllProjectTypes() {
        return projectTypeLookupRepository.findAll();
    }
}
