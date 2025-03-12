package com.andhraempower.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cultivation_crops_village")
public class CultivationCropsVillage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "village_id")
    private Integer villageId;

    @Column(name = "cultivation_id")
    private Integer cultivationId;

    @Column(name = "season_name")
    private String seasonName;

    @Column(name = "total_acrs")
    private Integer totalAcrs;

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

    public Integer getCultivationId() {
        return cultivationId;
    }

    public void setCultivationId(Integer cultivationId) {
        this.cultivationId = cultivationId;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public Integer getTotalAcrs() {
        return totalAcrs;
    }

    public void setTotalAcrs(Integer totalAcrs) {
        this.totalAcrs = totalAcrs;
    }
}
