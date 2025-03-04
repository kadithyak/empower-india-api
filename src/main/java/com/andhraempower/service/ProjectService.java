package com.andhraempower.service;

import com.andhraempower.constants.StatusEnum;
import com.andhraempower.dto.ProjectRequestDto;
import com.andhraempower.dto.ProjectResponseDto;
import com.andhraempower.entity.*;
import com.andhraempower.repository.ProjectRepository;
import com.andhraempower.dao.LookupDAO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Slf4j
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final LookupDAO lookupDAO;

    public void saveProject(ProjectRequestDto projectRequestDto) {
        log.info("Saving new project: {}", projectRequestDto);
        Optional<VillageLookup> village = getVillageLookup(projectRequestDto.getVillageId());
        Optional<CategoryLookup> category = getCategoryLookup(projectRequestDto.getProjectCategoryId());
        VillageProject project = getVillageProject(projectRequestDto, category, village);
        project.setStatusCode(StatusEnum.NEW.name());
        projectRepository.save(project);
        log.info("New Project saved successfully!");
    }
    public void updateProject(ProjectRequestDto projectRequestDto) {
        projectRepository.findById(projectRequestDto.getId())
                .ifPresentOrElse(project -> {
                    projectRepository.save(getUpdatedProject(project, projectRequestDto));
                    log.info("New Project Updated successfully!");
                }, () -> {throw new IllegalArgumentException("Project Not found for the given Id : " + projectRequestDto.getId());});
    }

    private Optional<CategoryLookup> getCategoryLookup(Integer categoryId) {
        return lookupDAO.getCategorybyId(categoryId);
    }

    private Optional<VillageLookup> getVillageLookup(Integer villageId) {
        return lookupDAO.getVillageById(villageId);
    }

    public Page<ProjectResponseDto> getProjects(Pageable pageable) {
        log.info("Fetching all projects details.");
        return projectRepository.findAllProjects(pageable);
    }

    public List<ProjectResponseDto> searchProjectsByDistrictMandalVillageCode(Long districtCode, Long mandalCode, Long villageCode) {
        log.info("searchProjectsByDistrictMandalVillageCode districtCode {}, mandalCode{}, villageCode {}", districtCode, mandalCode, villageCode);
        return projectRepository.searchProjects(districtCode, mandalCode, villageCode);
    }

    private VillageProject getUpdatedProject(VillageProject villageProject, ProjectRequestDto projectRequestDto){
        villageProject.setLocation(projectRequestDto.getLocation());
        villageProject.setLatitude(projectRequestDto.getLatitude());
        villageProject.setLongitude(projectRequestDto.getLongitude());
        villageProject.setIsNew("New".equalsIgnoreCase(projectRequestDto.getProjectNeed()));
        villageProject.setGovernmentShare(projectRequestDto.getGovernmentShare());
        villageProject.setProjectEstimation(projectRequestDto.getProjectEstimation());
        villageProject.setPublicShare(projectRequestDto.getPublicShare());
        villageProject.setDescription(projectRequestDto.getDescription());

        if(!villageProject.getVillage().getId().equals(projectRequestDto.getVillageId())) {
            Optional<VillageLookup> villageLookup = getVillageLookup(projectRequestDto.getVillageId());
            if(villageLookup.isEmpty()){
                throw new IllegalArgumentException("Invalid Village Id : " + projectRequestDto.getVillageId());
            }
            villageProject.setVillage(villageLookup.get());
        }

        if(!villageProject.getProjectCategory().getId().equals(projectRequestDto.getProjectCategoryId())) {
            Optional<CategoryLookup> categoryLookup = getCategoryLookup(projectRequestDto.getProjectCategoryId());
            if(categoryLookup.isEmpty()) {
                throw new IllegalArgumentException("Invalid Category Id : " + projectRequestDto.getProjectCategoryId());
            }
            villageProject.setProjectCategory(categoryLookup.get());
            villageProject.setProjectTypeLookup(getProjectTypeLookup(projectRequestDto, categoryLookup));
        }
        return villageProject;

    }

    private static VillageProject getVillageProject(ProjectRequestDto projectRequestDto
            , Optional<CategoryLookup> category, Optional<VillageLookup> village) {
        if (village.isEmpty()) {
            throw new IllegalArgumentException("Invalid Village Id : " + projectRequestDto.getVillageId());
        }
        if(category.isEmpty()) {
            throw new IllegalArgumentException("Invalid Category Id : " + projectRequestDto.getProjectCategoryId());
        }
        ProjectTypeLookup projectTypeLookup = getProjectTypeLookup(projectRequestDto, category);
        return VillageProject.builder()
                .location(projectRequestDto.getLocation())
                .latitude(projectRequestDto.getLatitude())
                .longitude(projectRequestDto.getLongitude())
                .projectCategory(category.get())
                .projectTypeLookup(projectTypeLookup)
                .isNew("New".equalsIgnoreCase(projectRequestDto.getProjectNeed()))
                .projectEstimation(projectRequestDto.getProjectEstimation())
                .governmentShare(projectRequestDto.getGovernmentShare())
                .publicShare(projectRequestDto.getPublicShare())
                .description(projectRequestDto.getDescription())
                .village(village.get())
                .status("Open")
                .createdBy("Admin")
                .lastUpdatedBy("Admin")
                .build();
    }

    private static ProjectTypeLookup getProjectTypeLookup(ProjectRequestDto projectRequestDto, Optional<CategoryLookup> category) {
        return category.get().getProjects().stream().filter(projectType -> projectType.getId().equals(Long.parseLong(projectRequestDto.getProjectType())))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Invalid Project Type Id : " + projectRequestDto.getProjectCategoryId()));
    }
}
