package com.andhraempower.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="category_lookup")
public class CategoryLookup {

    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
        name="project_category",
        joinColumns = @JoinColumn(name="category_id"),
        inverseJoinColumns = @JoinColumn(name="project_id")
    )
    private List<ProjectLookup> projects;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProjectLookup> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectLookup> projects) {
        this.projects = projects;
    }
}
