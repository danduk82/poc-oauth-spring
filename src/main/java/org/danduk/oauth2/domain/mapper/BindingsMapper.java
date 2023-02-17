package org.danduk.oauth2.domain.mapper;

import org.danduk.oauth2.gen.model.Bindings;
import org.danduk.oauth2.integration.persistence.entities.BindingsEntity;

public class BindingsMapper {
    public static Bindings bindingsEntityToBindings(final BindingsEntity bindingsEntity){
        final var bindings = new Bindings();
        bindings.setId((int) bindingsEntity.getId());
        bindings.setRoleId(bindingsEntity.getFkRoleId().intValue());
        bindings.setUserId(bindingsEntity.getFkUsersId().intValue());
        return bindings;
    }
}
