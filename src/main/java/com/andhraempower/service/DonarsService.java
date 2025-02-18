package com.andhraempower.service;

import com.andhraempower.entity.Donars;
import com.andhraempower.repository.DonarsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
@Slf4j
public class DonarsService {

    @Autowired
    private DonarsRepository donarsRepository;

    public Donars addDonars(Donars donars) {
        return donarsRepository.save(donars);
    }

    public List<Donars> getDonars() {
        return donarsRepository.findAll();
    }
}
