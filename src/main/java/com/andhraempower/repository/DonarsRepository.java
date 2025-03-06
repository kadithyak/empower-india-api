package com.andhraempower.repository;

import com.andhraempower.entity.Donar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonarsRepository extends JpaRepository<Donar, Integer> {

}
