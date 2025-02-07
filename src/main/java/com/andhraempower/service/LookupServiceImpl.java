package com.andhraempower.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.andhraempower.dao.LookupDAO;
import com.andhraempower.entity.CategoryLookup;
import com.andhraempower.entity.DistrictLookup;
import com.andhraempower.entity.MandalLookup;
import com.andhraempower.entity.StateLookup;
import com.andhraempower.entity.VillageLookup;


@Service
public class LookupServiceImpl implements LookupService {

    private LookupDAO lookupDAO;

    public LookupServiceImpl(LookupDAO lookupDAO) {
        this.lookupDAO = lookupDAO;
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
    
    
}
