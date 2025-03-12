package com.andhraempower.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "village_demographics")
public class VillageDemographics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "village_id")
    private Integer villageId;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "village_id")
    private List<PopulationVillage> populations;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "village_id")
    private List<UnemployeeYouthVillage> unEmployedYouthVillage;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "village_id")
    private List<EmployeeYouthVillage> employedYouthVillage;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "village_id")
    private List<OccupationVillage> occupations;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "village_id")
    private List<LandUtilizationVillage> landUtilizationVillage;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "village_id")
    private List<CultivationCropsVillage> cultivationCropsVillage;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "village_id")
    private List<LiveStockVillage> liveStockVillages;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "village_id")
    private List<InstitutionsVillage> institutionsVillages;


    @Column(name = "no_of_houses")
    private Integer noOfHouses;

    @Column(name = "total_population")
    private Integer totalPopulation;

    @Column(name = "adult_male_population")
    private Integer adultMalePopulation;

    @Column(name = "adult_female_population")
    private Integer adultFemalePopulation;

    @Column(name = "child_male_population")
    private Integer childMalePopulation;

    @Column(name = "child_female_population")
    private Integer childFemalePopulation;

    @Column(name = "sc_male")
    private Integer scMale;

    @Column(name = "sc_female")
    private Integer scFemale;

    @Column(name = "st_male")
    private Integer stMale;

    @Column(name = "st_female")
    private Integer stFemale;

    @Column(name = "bc_male")
    private Integer bcMale;

    @Column(name = "bc_female")
    private Integer bcFemale;

    @Column(name = "oc_male")
    private Integer ocMale;

    @Column(name = "oc_female")
    private Integer ocFemale;

    @Column(name = "other_male")
    private Integer otherMale;

    @Column(name = "other_female")
    private Integer otherFemale;

    @Column(name = "area")
    private Float area;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVillageId() {
        return villageId;
    }

    public void setVillageId(Integer villageId) {
        this.villageId = villageId;
    }

    public Integer getNoOfHouses() {
        return noOfHouses;
    }

    public void setNoOfHouses(Integer noOfHouses) {
        this.noOfHouses = noOfHouses;
    }

    public Integer getTotalPopulation() {
        return totalPopulation;
    }

    public void setTotalPopulation(Integer totalPopulation) {
        this.totalPopulation = totalPopulation;
    }

    public Integer getAdultMalePopulation() {
        return adultMalePopulation;
    }

    public void setAdultMalePopulation(Integer adultMalePopulation) {
        this.adultMalePopulation = adultMalePopulation;
    }

    public Integer getAdultFemalePopulation() {
        return adultFemalePopulation;
    }

    public void setAdultFemalePopulation(Integer adultFemalePopulation) {
        this.adultFemalePopulation = adultFemalePopulation;
    }

    public Integer getChildMalePopulation() {
        return childMalePopulation;
    }

    public void setChildMalePopulation(Integer childMalePopulation) {
        this.childMalePopulation = childMalePopulation;
    }

    public Integer getChildFemalePopulation() {
        return childFemalePopulation;
    }

    public void setChildFemalePopulation(Integer childFemalePopulation) {
        this.childFemalePopulation = childFemalePopulation;
    }

    public Integer getScMale() {
        return scMale;
    }

    public void setScMale(Integer scMale) {
        this.scMale = scMale;
    }

    public Integer getScFemale() {
        return scFemale;
    }

    public void setScFemale(Integer scFemale) {
        this.scFemale = scFemale;
    }

    public Integer getStMale() {
        return stMale;
    }

    public void setStMale(Integer stMale) {
        this.stMale = stMale;
    }

    public Integer getStFemale() {
        return stFemale;
    }

    public void setStFemale(Integer stFemale) {
        this.stFemale = stFemale;
    }

    public Integer getBcMale() {
        return bcMale;
    }

    public void setBcMale(Integer bcMale) {
        this.bcMale = bcMale;
    }

    public Integer getBcFemale() {
        return bcFemale;
    }

    public void setBcFemale(Integer bcFemale) {
        this.bcFemale = bcFemale;
    }

    public Integer getOcMale() {
        return ocMale;
    }

    public void setOcMale(Integer ocMale) {
        this.ocMale = ocMale;
    }

    public Integer getOcFemale() {
        return ocFemale;
    }

    public void setOcFemale(Integer ocFemale) {
        this.ocFemale = ocFemale;
    }

    public Integer getOtherMale() {
        return otherMale;
    }

    public void setOtherMale(Integer otherMale) {
        this.otherMale = otherMale;
    }

    public Integer getOtherFemale() {
        return otherFemale;
    }

    public void setOtherFemale(Integer otherFemale) {
        this.otherFemale = otherFemale;
    }

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public List<PopulationVillage> getPopulations() {
        return populations;
    }

    public void setPopulations(List<PopulationVillage> populations) {
        this.populations = populations;
    }

    public List<OccupationVillage> getOccupations() {
        return occupations;
    }

    public void setOccupations(List<OccupationVillage> occupations) {
        this.occupations = occupations;
    }

    public List<UnemployeeYouthVillage> getUnEmployedYouthVillage() {
        return unEmployedYouthVillage;
    }

    public void setUnEmployedYouthVillage(List<UnemployeeYouthVillage> unEmployedYouthVillage) {
        this.unEmployedYouthVillage = unEmployedYouthVillage;
    }

    public List<EmployeeYouthVillage> getEmployedYouthVillage() {
        return employedYouthVillage;
    }

    public void setEmployedYouthVillage(List<EmployeeYouthVillage> employedYouthVillage) {
        this.employedYouthVillage = employedYouthVillage;
    }

    public List<CultivationCropsVillage> getCultivationCropsVillage() {
        return cultivationCropsVillage;
    }

    public void setCultivationCropsVillage(List<CultivationCropsVillage> cultivationCropsVillage) {
        this.cultivationCropsVillage = cultivationCropsVillage;
    }

    public List<LandUtilizationVillage> getLandUtilizationVillage() {
        return landUtilizationVillage;
    }

    public void setLandUtilizationVillage(List<LandUtilizationVillage> landUtilizationVillage) {
        this.landUtilizationVillage = landUtilizationVillage;
    }

    public List<LiveStockVillage> getLiveStockVillages() {
        return liveStockVillages;
    }

    public void setLiveStockVillages(List<LiveStockVillage> liveStockVillages) {
        this.liveStockVillages = liveStockVillages;
    }

    public List<InstitutionsVillage> getInstitutionsVillages() {
        return institutionsVillages;
    }

    public void setInstitutionsVillages(List<InstitutionsVillage> institutionsVillages) {
        this.institutionsVillages = institutionsVillages;
    }
}