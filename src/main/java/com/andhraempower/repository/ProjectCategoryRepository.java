package com.andhraempower.repository;
import com.andhraempower.dto.ProjectCategoriesDto;
import com.andhraempower.entity.CategoryLookup;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectCategoryRepository extends JpaRepository<CategoryLookup, Integer> {

    @Query("SELECT new com.andhraempower.dto.ProjectCategoriesDto( " +
            "cl.id, cl.name) " +
            "FROM CategoryLookup cl " +
            "where cl.id IN (SELECT vp.projectCategory.id "+
            "FROM VillageProject vp) ")
    List<ProjectCategoriesDto> getCategoriesByProjects();
}

