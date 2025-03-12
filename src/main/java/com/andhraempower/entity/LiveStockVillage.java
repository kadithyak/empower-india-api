package com.andhraempower.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "live_stock_village")
public class LiveStockVillage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "village_id")
    private Integer villageId;

    @Column(name = "live_stock_id")
    private Integer liveStockId;

    @Column(name = "count")
    private Integer count;

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

    public Integer getLiveStockId() {
        return liveStockId;
    }

    public void setLiveStockId(Integer liveStockId) {
        this.liveStockId = liveStockId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
