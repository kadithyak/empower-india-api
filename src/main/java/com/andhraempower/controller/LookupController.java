package com.andhraempower.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.andhraempower.entity.CategoryLookup;
import com.andhraempower.entity.DistrictLookup;
import com.andhraempower.entity.MandalLookup;
import com.andhraempower.entity.StateLookup;
import com.andhraempower.entity.VillageLookup;
import com.andhraempower.service.LookupService;

@RestController
@RequestMapping("/api/lookup")
public class LookupController {

    private final LookupService lookupService;

    public LookupController(LookupService lookupService) {
        this.lookupService = lookupService;
    }

    @GetMapping("/states")
    public ResponseEntity<List<StateLookup>> getStates() {
        return ResponseEntity.ok().body(lookupService.getStates());
    }

    @GetMapping("/districts")
    public ResponseEntity<List<DistrictLookup>> getDistrictsByState(@RequestParam("stateId") Integer stateId) {
        if (stateId == null || stateId <= 0) {
            return ResponseEntity.badRequest().body(null); 
        }
        return ResponseEntity.ok().body(lookupService.getDistrictsByState(stateId));
    }

    @GetMapping("/mandals")
    public ResponseEntity<List<MandalLookup>> getMandalsByDistrict(@RequestParam("districtId") Integer districtId) {
        if (districtId == null || districtId <= 0) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(lookupService.getMandalsByDistrict(districtId));
    }

    @GetMapping("/villages")
    public ResponseEntity<List<VillageLookup>> getVillagesByMandal(@RequestParam("mandalId") Integer mandalId) {
        if (mandalId == null || mandalId <= 0) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(lookupService.getVillagesByMandal(mandalId));
    }

    @GetMapping("/project-categories")
    public ResponseEntity<List<CategoryLookup>> getCategories() {
        return ResponseEntity.ok().body(lookupService.getCategories());
    }
}

