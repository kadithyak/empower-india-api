package com.andhraempower.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "land_utilization_village")
public class LandUtilizationVillage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "village_id")
    private Integer villageId;

    @Column(name = "land_type_id")
    private Integer landTypeId;

    @Column(name = "total_area")
    private Integer totalArea;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVillageId() {
        return villageId;
    }

    public void setVillageId(Integer villageId) {
        this.villageId = villageId;
    }

    public Integer getLandTypeId() {
        return landTypeId;
    }

    public void setLandTypeId(Integer landTypeId) {
        this.landTypeId = landTypeId;
    }

    public Integer getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(Integer totalArea) {
        this.totalArea = totalArea;
    }
}
