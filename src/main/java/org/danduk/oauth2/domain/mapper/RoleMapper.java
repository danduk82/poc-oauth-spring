package org.danduk.oauth2.domain.mapper;

import org.danduk.oauth2.gen.model.Role;
import org.danduk.oauth2.integration.persistence.entities.RoleEntity;

public class RoleMapper {
    public static Role roleEntityToRole(final RoleEntity roleEntity){
        final var role = new Role();
        role.setId((int) roleEntity.getId());
        role.setName(roleEntity.getName());
        return role;
    }
}
