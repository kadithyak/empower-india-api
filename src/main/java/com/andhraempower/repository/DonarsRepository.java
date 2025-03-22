package com.andhraempower.repository;
import com.andhraempower.dto.DonarDto;
import com.andhraempower.dto.ProjectInfoDto;
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
    "d.id, d.firstName, d.lastName, d.phoneNumber, d.email, d.description, d.address, vl.id, vl.name, ml.id, ml.name, dl.id, dl.name, SUM(vpl.amount), " +
    "(SELECT sc.categoryName FROM SponsorCategory sc " +
    "WHERE SUM(vpl.amount) >= sc.minAmount " +
    "AND (sc.maxAmount IS NULL OR SUM(vpl.amount) <= sc.maxAmount) " +
    "AND sc.minAmount = (SELECT MAX(sc2.minAmount) FROM SponsorCategory sc2 " +
    "WHERE SUM(vpl.amount) >= sc2.minAmount) " +
    ") " +
    ") " +
    "FROM VillageProjectDonar vpl " +
    "JOIN Donar d ON vpl.donar.id = d.id " +
    "LEFT JOIN VillageLookup vl ON d.village.id = vl.id " +
    "LEFT JOIN MandalLookup ml ON vl.mandalId = ml.id " +
    "LEFT JOIN DistrictLookup dl ON ml.districtId = dl.id "+
    "GROUP BY d.id, d.firstName, d.lastName, d.phoneNumber, d.email, d.address, vl.id, vl.name, ml.id, ml.name, dl.id, dl.name " +
    "ORDER BY SUM(vpl.amount) DESC")
  List<DonarDto> findDonars(Pageable pageable);

  @Query("SELECT new com.andhraempower.dto.ProjectInfoDto( " +
    "vpd.donar.id, vpd.memoryOf, vpd.modeOfPayment, vpd.amount, "+ 
    "vp.id, cl.name, ptl.description, "+ 
    "vp.location, vl.id, vl.name, ml.id, ml.name, dl.id, dl.name ) "+
    "FROM VillageProjectDonar vpd " +
    //"JOIN Donar d ON vpd.donar.id = d.id " +
    "JOIN VillageProject vp ON vp.id = vpd.villageProjectId "+
    "LEFT JOIN CategoryLookup cl ON vp.projectCategory.id = cl.id " +
    "LEFT JOIN ProjectTypeLookup ptl ON vp.projectTypeLookup.id = ptl.id " +
    "LEFT JOIN VillageLookup vl ON vp.village.id = vl.id " +
    "LEFT JOIN MandalLookup ml ON vl.mandalId = ml.id " +
    "LEFT JOIN DistrictLookup dl ON ml.districtId = dl.id "+
    "WHERE (vpd.donar.id = :donarId) " +
    "ORDER BY vp.id DESC")
  List<ProjectInfoDto> findDonar(
    @Param("donarId") Long donarId
  );

}
