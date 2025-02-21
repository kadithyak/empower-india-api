package com.andhraempower.service;

import com.andhraempower.entity.Vendors;
import com.andhraempower.repository.VendorsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class VendorsService {
    @Autowired
    private VendorsRepository vendorsRepository;

    public Vendors addVendors(Vendors vendors) {
        return vendorsRepository.save(vendors);
    }

    public List<Vendors> getVendors() {
        return vendorsRepository.findAll();
    }
}
