package com.andhraempower.service;

import com.andhraempower.dto.ProjectRequestDto;
import com.andhraempower.dto.ProjectResponseDto;
import com.andhraempower.entity.VillageProject;
import com.andhraempower.entity.VillageLookup;
import com.andhraempower.entity.MandalLookup;
import com.andhraempower.entity.DistrictLookup;
import com.andhraempower.entity.CategoryLookup;
import com.andhraempower.repository.ProjectRepository;
import com.andhraempower.dao.LookupDAO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
        log.info("Saving new project: {}", projectRequestDto.getProjectName());

        Optional<VillageLookup> villageOpt = lookupDAO.getVillagesByMandal(
                        lookupDAO.getMandalsByDistrict(
                                        lookupDAO.getDistrictsByState(1)
                                                .stream()
                                                .filter(d -> d.getName().equalsIgnoreCase(projectRequestDto.getDistrict()))
                                                .findFirst()
                                                .orElseThrow(() -> new IllegalArgumentException("Invalid District Name: " + projectRequestDto.getDistrict()))
                                                .getId()
                                )
                                .stream()
                                .filter(m -> m.getName().equalsIgnoreCase(projectRequestDto.getMandal()))
                                .findFirst()
                                .orElseThrow(() -> new IllegalArgumentException("Invalid Mandal Name: " + projectRequestDto.getMandal()))
                                .getId()
                ).stream()
                .filter(v -> v.getName().equalsIgnoreCase(projectRequestDto.getVillage()))
                .findFirst();

        if (villageOpt.isEmpty()) {
            throw new IllegalArgumentException("Invalid Village Name: " + projectRequestDto.getVillage());
        }
        VillageLookup village = villageOpt.get();

        Integer villageProposalId = lookupDAO.getVillageProposalIdByVillageId(village.getId())
                .orElseThrow(() -> new IllegalArgumentException("No proposal found for Village ID: " + village.getId()));

        Optional<CategoryLookup> categoryOpt = lookupDAO.getCategories().stream()
                .filter(c -> c.getName().equalsIgnoreCase(projectRequestDto.getProjectCategory()))
                .findFirst();

        if (categoryOpt.isEmpty()) {
            throw new IllegalArgumentException("Invalid Project Category: " + projectRequestDto.getProjectCategory());
        }
        CategoryLookup category = categoryOpt.get();

        VillageProject project = VillageProject.builder()
                .villageProposalId(villageProposalId)
                .location(projectRequestDto.getLocation())
                .latitude(projectRequestDto.getLatitude())
                .longitude(projectRequestDto.getLongitude())
                .projectCategory(category)
                .projectName(projectRequestDto.getProjectName())
                .isNew("New".equalsIgnoreCase(projectRequestDto.getProjectNeed()))
                .projectEstimation(projectRequestDto.getProjectEstimation())
                .governmentShare(projectRequestDto.getGovernmentShare())
                .publicShare(projectRequestDto.getPublicShare())
                .description(projectRequestDto.getDescription())
                .status("Open")
                .createdBy("Admin")
                .lastUpdatedBy("Admin")
                .build();

        projectRepository.save(project);
        log.info("New Project saved successfully!");
    }

    public List<ProjectResponseDto> getProjects() {
        log.info("Fetching all projects details.");
        return projectRepository.findAllProjects();
    }
}
