package com.andhraempower.dao;

import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;

import com.andhraempower.entity.*;

public interface LookupDAO {

    List<StateLookup> getStates();

    List<DistrictLookup> getDistrictsByState(Integer stateId);

    List<MandalLookup> getMandalsByDistrict(Integer districtId);

    List<VillageLookup> getVillagesByMandal(Integer mandalId);

    List<CategoryLookup> getCategories();

    Optional<Integer> getVillageProposalIdByVillageId(Integer villageId);

    Optional<VillageLookup> getVillageById(Integer villageId);
    Optional<CategoryLookup> getCategorybyId(Integer categoryId);

    List<ProjectTypeLookup> getProjectTypes();

}
