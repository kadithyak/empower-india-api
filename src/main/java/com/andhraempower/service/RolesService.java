package com.andhraempower.service;

import com.andhraempower.dto.RoleDto;
import com.andhraempower.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolesService {

    @Autowired
    private RolesRepository rolesRepository;

    public List<RoleDto> getRoles() {
        return rolesRepository.findAll().stream().map(role -> new RoleDto(role.getId(), role.getName())).collect(Collectors.toList());
    }
}
