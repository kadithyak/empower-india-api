package com.andhraempower.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "occupation_village")
public class OccupationVillage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "occupation_id")
    private Integer occupationId;

    @Column(name = "village_id")
    private Integer villageId;

    @Column(name = "no_of_families")
    private Integer noOfFamilies;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOccupationId() {
        return occupationId;
    }

    public void setOccupationId(Integer occupationId) {
        this.occupationId = occupationId;
    }

    public Integer getVillageId() {
        return villageId;
    }

    public void setVillageId(Integer villageId) {
        this.villageId = villageId;
    }

    public Integer getNoOfFamilies() {
        return noOfFamilies;
    }

    public void setNoOfFamilies(Integer noOfFamilies) {
        this.noOfFamilies = noOfFamilies;
    }
}
