package com.andhraempower.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.andhraempower.dao.LookupDAO;
import com.andhraempower.dto.ProjectCategoriesDto;
import com.andhraempower.entity.CategoryLookup;
import com.andhraempower.entity.DistrictLookup;
import com.andhraempower.entity.MandalLookup;
import com.andhraempower.entity.StateLookup;
import com.andhraempower.entity.VillageLookup;
import com.andhraempower.repository.ProjectCategoryRepository;


@Service
public class LookupServiceImpl implements LookupService {

    private ProjectCategoryRepository projectCategoryRepository;
    private LookupDAO lookupDAO;

    public LookupServiceImpl(LookupDAO lookupDAO, ProjectCategoryRepository projectCategoryRepository) {
        this.lookupDAO = lookupDAO;
        this.projectCategoryRepository = projectCategoryRepository;
    }

    @Override
    public List<StateLookup> getStates() {
        return this.lookupDAO.getStates();
    }

    @Override
    public List<DistrictLookup> getDistrictsByState(Integer stateId) {
        return this.lookupDAO.getDistrictsByState(stateId);
    }

    @Override
    public List<MandalLookup> getMandalsByDistrict(Integer districtId) {
        return this.lookupDAO.getMandalsByDistrict(districtId);   
    }

    @Override
    public List<VillageLookup> getVillagesByMandal(Integer mandalId) {
        return this.lookupDAO.getVillagesByMandal(mandalId);   
    }

    @Override
    public List<CategoryLookup> getCategories() {
        return this.lookupDAO.getCategories();   
    }

    @Override
    public List<ProjectCategoriesDto> getCategoriesByProjects() {
        return this.projectCategoryRepository.getCategoriesByProjects();   
    }
    
    
}
