package org.danduk.oauth2.domain;

import org.danduk.oauth2.domain.mapper.UserMapper;
import org.danduk.oauth2.gen.model.User;
import org.danduk.oauth2.integration.persistence.entities.UsersEntity;
import org.danduk.oauth2.integration.persistence.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.lang.invoke.MethodHandles;

@Service
public class UserService {
    static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final UserRepository userRepository;

    @Autowired
    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User findUserById(final long id) throws NotFoundException {
        return userRepository.findById(id).map(UserMapper::userEntityToUser)
                .orElseThrow(
                        () -> new NotFoundException("not found: %s with id = %s".formatted(UsersEntity.class.getSimpleName(), String.valueOf(id))));
    }
}
