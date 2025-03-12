package com.andhraempower.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "population_village")
public class PopulationVillage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "village_id")
    private Integer villageId;

    @Column(name = "community_id")
    private Integer communityId;

    @Column(name = "male")
    private Integer male;

    @Column(name = "female")
    private Integer female;

    @Column(name = "total")
    private Integer total;


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

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public Integer getMale() {
        return male;
    }

    public void setMale(Integer male) {
        this.male = male;
    }

    public Integer getFemale() {
        return female;
    }

    public void setFemale(Integer female) {
        this.female = female;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
