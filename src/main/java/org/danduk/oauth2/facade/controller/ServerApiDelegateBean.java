package org.danduk.oauth2.facade.controller;


import org.danduk.oauth2.domain.ServerService;
import org.danduk.oauth2.gen.api.ServerApiDelegate;
import org.danduk.oauth2.gen.model.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

import java.lang.invoke.MethodHandles;

@Component
public class ServerApiDelegateBean  implements ServerApiDelegate {
    static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final ServerService serverService;

    @Autowired
    public ServerApiDelegateBean(ServerService serverService) {
        this.serverService = serverService;
    }

    @Override
    public ResponseEntity<Server> serverGetById(Integer id){
        try {
            return new ResponseEntity<>(serverService.findServerById(id), HttpStatus.OK);
        }
        catch (final NotFoundException e){
            logger.error(e.toString());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
