package org.danduk.oauth2.domain.mapper;

import org.danduk.oauth2.gen.model.User;
import org.danduk.oauth2.integration.persistence.entities.UsersEntity;

public class UserMapper {
    public static User userEntityToUser(final UsersEntity userEntity){
        final var user = new User();
        user.setId((int) userEntity.getId());
        user.setName(userEntity.getName());
        user.setEmail(userEntity.getEmail());
        user.setLastname(userEntity.getLastname());
        return user;
    }
}
