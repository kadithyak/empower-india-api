package com.andhraempower.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.andhraempower.entity.CategoryLookup;
import com.andhraempower.entity.DistrictLookup;
import com.andhraempower.entity.MandalLookup;
import com.andhraempower.entity.StateLookup;
import com.andhraempower.entity.VillageLookup;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class LookupDAOImpl implements LookupDAO{

     private EntityManager entityManager;

    @Autowired
    public LookupDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

  @Override
    public List<StateLookup> getStates() {
        TypedQuery<StateLookup> theQuery = entityManager.createQuery("FROM StateLookup order by name", StateLookup.class);
        return theQuery.getResultList();
   
    }

@Override
public List<DistrictLookup> getDistrictsByState(Integer stateId) {
    TypedQuery<DistrictLookup> theQuery = entityManager.createQuery("FROM DistrictLookup dl where dl.stateId = :stateId order by dl.name", DistrictLookup.class);
    theQuery.setParameter("stateId", stateId);
    return theQuery.getResultList();
}

@Override
public List<MandalLookup> getMandalsByDistrict(Integer districtId) {
    TypedQuery<MandalLookup> theQuery = entityManager.createQuery("FROM MandalLookup ml where ml.districtId = :districtId order by ml.name", MandalLookup.class);
    theQuery.setParameter("districtId", districtId);
    return theQuery.getResultList();
}

@Override
public List<VillageLookup> getVillagesByMandal(Integer mandalId) {
    TypedQuery<VillageLookup> theQuery = entityManager.createQuery("FROM VillageLookup vl where vl.mandalId = :mandalId order by vl.name", VillageLookup.class);
    theQuery.setParameter("mandalId", mandalId);
    return theQuery.getResultList();
 }

@Override
public List<CategoryLookup> getCategories() {

    // create query

    TypedQuery<CategoryLookup> query = entityManager.createQuery(
        "select i from CategoryLookup i " 
        +"JOIN FETCH i.projects ", CategoryLookup.class);
    
    // execute query
    List<CategoryLookup> categories = query.getResultList();
    return categories;
 }
    
}
