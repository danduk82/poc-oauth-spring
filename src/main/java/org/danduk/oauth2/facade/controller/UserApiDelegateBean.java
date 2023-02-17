package org.danduk.oauth2.facade.controller;


import org.danduk.oauth2.domain.UserService;
import org.danduk.oauth2.gen.api.UserApiDelegate;
import org.danduk.oauth2.gen.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

import java.lang.invoke.MethodHandles;

@Component
public class UserApiDelegateBean  implements UserApiDelegate {
    static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final UserService userService;

    @Autowired
    public UserApiDelegateBean(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<User> userGetById(Integer id){
        try {
            return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
        }
        catch (final NotFoundException e){
            logger.error(e.toString());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
