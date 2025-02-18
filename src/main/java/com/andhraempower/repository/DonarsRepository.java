package com.andhraempower.repository;

import com.andhraempower.entity.Donars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonarsRepository extends JpaRepository<Donars, Integer> {
}
