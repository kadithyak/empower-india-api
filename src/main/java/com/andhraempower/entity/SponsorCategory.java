package com.andhraempower.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sponsor_category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SponsorCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "category_name", nullable = false, unique = true)
    private String categoryName;

    @Column(name = "min_amount", nullable = false)
    private Double minAmount;

    @Column(name = "max_amount")
    private Double maxAmount; // Null means no upper limit (Platinum)
}