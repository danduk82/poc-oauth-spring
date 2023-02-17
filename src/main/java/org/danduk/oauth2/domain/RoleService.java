package org.danduk.oauth2.domain;

import org.danduk.oauth2.domain.mapper.RoleMapper;
import org.danduk.oauth2.gen.model.Role;
import org.danduk.oauth2.integration.persistence.entities.RoleEntity;
import org.danduk.oauth2.integration.persistence.repositories.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.lang.invoke.MethodHandles;

@Service
public class RoleService {
    static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(final RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    public Role findRoleById(final long id) throws NotFoundException {
        return roleRepository.findById(id).map(RoleMapper::roleEntityToRole)
                .orElseThrow(
                        () -> new NotFoundException("not found: %s with id = %s".formatted(RoleEntity.class.getSimpleName(), String.valueOf(id))));
    }
}
