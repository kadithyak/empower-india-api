package com.andhraempower.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name ="village_project_vendor")
public class VillageProjectVendor extends Audit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "village_project_id")
    private Long villageProjectId;

    @OneToOne
    @JoinColumn(name = "vendor_id")
    private Vendors vendor;
}
