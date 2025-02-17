package com.andhraempower.dao;

import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;

import com.andhraempower.entity.CategoryLookup;
import com.andhraempower.entity.DistrictLookup;
import com.andhraempower.entity.MandalLookup;
import com.andhraempower.entity.StateLookup;
import com.andhraempower.entity.VillageLookup;

public interface LookupDAO {

    List<StateLookup> getStates();

    List<DistrictLookup> getDistrictsByState(Integer stateId);

    List<MandalLookup> getMandalsByDistrict(Integer districtId);

    List<VillageLookup> getVillagesByMandal(Integer mandalId);

    List<CategoryLookup> getCategories();

    Optional<Integer> getVillageProposalIdByVillageId(Integer villageId);

    Optional<VillageLookup> getVillageById(Integer villageId);
    Optional<CategoryLookup> getCategorybyId(Integer categoryId);

}
