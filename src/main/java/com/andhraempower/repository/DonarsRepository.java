package com.andhraempower.repository;

import com.andhraempower.dto.DonarDto;
import com.andhraempower.entity.Donar;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DonarsRepository extends JpaRepository<Donar, Integer> {

@Query("SELECT new com.andhraempower.dto.DonarDto( " +
    "d.firstName, d.lastName, d.phoneNumber, d.email, d.address, SUM(vpl.amount), " +
    "(SELECT sc.categoryName FROM SponsorCategory sc " +
    "WHERE SUM(vpl.amount) >= sc.minAmount " +
    "AND (sc.maxAmount IS NULL OR SUM(vpl.amount) <= sc.maxAmount) " +
    "AND sc.minAmount = (SELECT MAX(sc2.minAmount) FROM SponsorCategory sc2 " +
    "WHERE SUM(vpl.amount) >= sc2.minAmount) " +
    ") " +
    ") " +
    "FROM VillageProjectDonar vpl " +
    "JOIN Donar d ON vpl.donar.id = d.id " +
    "GROUP BY d.firstName, d.lastName, d.phoneNumber, d.email, d.address " +
    "ORDER BY SUM(vpl.amount) DESC")
  List<DonarDto> findTopDonars(Pageable pageable);

@Query("SELECT new com.andhraempower.dto.DonarDto( " +
    "d.firstName, d.lastName, d.phoneNumber, d.email, d.address, SUM(vpl.amount), " +
    "(SELECT sc.categoryName FROM SponsorCategory sc " +
    "WHERE SUM(vpl.amount) >= sc.minAmount " +
    "AND (sc.maxAmount IS NULL OR SUM(vpl.amount) <= sc.maxAmount) " +
    "AND sc.minAmount = (SELECT MAX(sc2.minAmount) FROM SponsorCategory sc2 " +
    "WHERE SUM(vpl.amount) >= sc2.minAmount) " +
    ") " +
    ") " +
    "FROM VillageProjectDonar vpl " +
    "JOIN Donar d ON vpl.donar.id = d.id " +
    "GROUP BY d.firstName, d.lastName, d.phoneNumber, d.email, d.address " +
    "ORDER BY SUM(vpl.amount) DESC")
  List<DonarDto> findAllDonars();

  @Query("SELECT new com.andhraempower.dto.DonarDto( " +
    "d.firstName, d.lastName, d.phoneNumber, d.email, d.address, vpl.amount) "+ 
    "FROM VillageProjectDonar vpl " +
    "JOIN Donar d ON vpl.donar.id = d.id " +
    "WHERE (:firstName IS NULL OR d.firstName = :firstName) " +
    "AND (:lastName IS NULL OR d.lastName = :lastName) " +
    "AND (:phoneNumber IS NULL OR d.phoneNumber = :phoneNumber) " +
    "AND (:email IS NULL OR d.email = :email) " +
    "AND (:address IS NULL OR d.address = :address) " +
    "ORDER BY d.id DESC")
  List<DonarDto> findDonar(
    @Param("firstName") String firstName,
    @Param("lastName") String lastName,
    @Param("phoneNumber") String phoneNumber,
    @Param("email") String email,
    @Param("address") String address
  );


}
