package com.andhraempower.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_youth_village")
public class EmployeeYouthVillage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "community_id")
    private Integer communityId;

    @Column(name = "village_id")
    private Integer villageId;

    @Column(name = "government")
    private Integer government;


    @Column(name = "private_job")
    private Integer privateJob;

    @Column(name = "self_employee")
    private Integer selfEmployee;


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

    public Integer getVillageId() {
        return villageId;
    }

    public void setVillageId(Integer villageId) {
        this.villageId = villageId;
    }

    public Integer getGovernment() {
        return government;
    }

    public void setGovernment(Integer government) {
        this.government = government;
    }

    public Integer getPrivateJob() {
        return privateJob;
    }

    public void setPrivateJob(Integer privateJob) {
        this.privateJob = privateJob;
    }

    public Integer getSelfEmployee() {
        return selfEmployee;
    }

    public void setSelfEmployee(Integer selfEmployee) {
        this.selfEmployee = selfEmployee;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
