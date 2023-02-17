package org.danduk.oauth2.facade.controller;


import org.danduk.oauth2.domain.AclService;
import org.danduk.oauth2.gen.api.AclApiDelegate;
import org.danduk.oauth2.gen.model.Acl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

import java.lang.invoke.MethodHandles;

@Component
public class AclApiDelegateBean  implements AclApiDelegate {
    static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final AclService aclService;

    @Autowired
    public AclApiDelegateBean(AclService aclService) {
        this.aclService = aclService;
    }

    @Override
    public ResponseEntity<Acl> aclGetById(Integer id){
        try {
            return new ResponseEntity<>(aclService.findAclById(id), HttpStatus.OK);
        }
        catch (final NotFoundException e){
            logger.error(e.toString());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
