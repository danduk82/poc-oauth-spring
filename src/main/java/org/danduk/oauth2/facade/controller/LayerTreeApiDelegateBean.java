package org.danduk.oauth2.facade.controller;


import org.danduk.oauth2.domain.LayerService;
import org.danduk.oauth2.domain.LayerTreeService;
import org.danduk.oauth2.gen.api.LayerApiDelegate;
import org.danduk.oauth2.gen.api.LayertreeApiDelegate;
import org.danduk.oauth2.gen.model.Layer;
import org.danduk.oauth2.gen.model.Layertree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

import java.lang.invoke.MethodHandles;

@Component
public class LayerTreeApiDelegateBean implements LayertreeApiDelegate {
    static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final LayerTreeService layerTreeService;

    @Autowired
    public LayerTreeApiDelegateBean(LayerTreeService layerTreeService) {
        this.layerTreeService = layerTreeService;
    }

    @Override
    public ResponseEntity<Layertree> layertreeGet(){
        String userEmail = "andrea.borghi@camptocamp.com";
        try {
            return new ResponseEntity<>(layerTreeService.createLayerTreeByEmail(userEmail), HttpStatus.OK);
        }
        catch (final NotFoundException e){
            logger.error(e.toString());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
