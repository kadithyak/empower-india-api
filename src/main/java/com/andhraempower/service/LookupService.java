package com.andhraempower.service;

import java.util.List;

import com.andhraempower.dto.ProjectCategoriesDto;
import com.andhraempower.entity.CategoryLookup;
import com.andhraempower.entity.DistrictLookup;
import com.andhraempower.entity.MandalLookup;
import com.andhraempower.entity.StateLookup;
import com.andhraempower.entity.VillageLookup;

public interface LookupService {

    List<StateLookup> getStates();

    List<DistrictLookup> getDistrictsByState(Integer stateId);

    List<MandalLookup> getMandalsByDistrict(Integer districtId);

    List<VillageLookup> getVillagesByMandal(Integer mandalId);

    List<CategoryLookup> getCategories();

    List<ProjectCategoriesDto> getCategoriesByProjects();
}
