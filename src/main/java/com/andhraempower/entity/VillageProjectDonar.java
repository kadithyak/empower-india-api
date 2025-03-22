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
@Table(name = "village_project_donar")
public class VillageProjectDonar extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "village_project_id")
    private Long villageProjectId;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "mode_of_payment")
    private String modeOfPayment;

    @Column(name = "memory_of")
    private String memoryOf;

    @OneToOne
    @JoinColumn(name = "donar_id")
    private Donar donar;

    
}
