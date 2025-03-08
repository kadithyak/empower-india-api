package com.andhraempower.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "project_status_lookup")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectStatusLookup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "status_code", nullable = false)
    private String statusCode;

    @Column(name = "status_name", nullable = false)
    private String statusName;

    @Column(name = "is_deleted", columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean isDeleted;
}
