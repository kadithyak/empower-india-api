package com.andhraempower.repository;

import com.andhraempower.entity.Role;
import com.andhraempower.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Role, Long> {
}
