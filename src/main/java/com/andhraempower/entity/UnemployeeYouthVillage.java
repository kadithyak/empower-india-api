package com.andhraempower.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "unemployee_youth_village")
public class UnemployeeYouthVillage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "village_id")
    private Integer villageId;

    @Column(name = "community_id")
    private Integer communityId;

    @Column(name = "age (18-30)")
    private Integer age1830;


    @Column(name = "age (31-45)")
    private Integer age3145;

    @Column(name = "age (46-60)")
    private Integer age4660;

    @Column(name = "total")
    private Integer total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public Integer getAge1830() {
        return age1830;
    }

    public void setAge1830(Integer age1830) {
        this.age1830 = age1830;
    }

    public Integer getAge3145() {
        return age3145;
    }

    public void setAge3145(Integer age3145) {
        this.age3145 = age3145;
    }

    public Integer getAge4660() {
        return age4660;
    }

    public void setAge4660(Integer age4660) {
        this.age4660 = age4660;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getVillageId() {
        return villageId;
    }

    public void setVillageId(Integer villageId) {
        this.villageId = villageId;
    }
}
