package com.andhraempower.repository;

import com.andhraempower.dto.DonarDto;
import com.andhraempower.entity.Donar;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

@Repository
public interface DonarInfoRepository extends JpaRepository<Donar, Integer> {

  /*@Query("SELECT new com.andhraempower.dto.DonarDto( " +
  " d.firstName, d.lastName, d.phoneNumber, d.email, SUM(d.amount), " +
  " (SELECT sc.categoryName FROM SponsorCategory sc " +
  "  WHERE SUM(d.amount) >= sc.minAmount " +
  "  AND (sc.maxAmount IS NULL OR SUM(d.amount) <= sc.maxAmount) " +
  "  AND sc.minAmount = (SELECT MAX(sc2.minAmount) FROM SponsorCategory sc2 " +
  "                     WHERE SUM(d.amount) >= sc2.minAmount) " +
  " ) " +
  ") " +
  "FROM Donar d " +
  "GROUP BY d.firstName, d.lastName, d.phoneNumber, d.email " +
  "ORDER BY SUM(d.amount) DESC")
  List<DonarDto> findTopDonars(Pageable pageable);*/
}
