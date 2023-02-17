package org.danduk.oauth2.facade.controller;


import org.danduk.oauth2.domain.RoleService;
import org.danduk.oauth2.gen.api.RoleApiDelegate;
import org.danduk.oauth2.gen.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

import java.lang.invoke.MethodHandles;

@Component
public class RoleApiDelegateBean  implements RoleApiDelegate {
    static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final RoleService roleService;

    @Autowired
    public RoleApiDelegateBean(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public ResponseEntity<Role> roleGetById(Integer id){
        try {
            return new ResponseEntity<>(roleService.findRoleById(id), HttpStatus.OK);
        }
        catch (final NotFoundException e){
            logger.error(e.toString());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
