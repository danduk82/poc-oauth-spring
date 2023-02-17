package org.danduk.oauth2.facade.controller;


import org.danduk.oauth2.domain.BindingsService;
import org.danduk.oauth2.gen.api.BindingsApiDelegate;
import org.danduk.oauth2.gen.model.Bindings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

import java.lang.invoke.MethodHandles;

@Component
public class BindingsApiDelegateBean  implements BindingsApiDelegate {
    static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final BindingsService bindingsService;

    @Autowired
    public BindingsApiDelegateBean(BindingsService bindingsService) {
        this.bindingsService = bindingsService;
    }

    @Override
    public ResponseEntity<Bindings> bindingsGetById(Integer id){
        try {
            return new ResponseEntity<>(bindingsService.findBindingsById(id), HttpStatus.OK);
        }
        catch (final NotFoundException e){
            logger.error(e.toString());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
