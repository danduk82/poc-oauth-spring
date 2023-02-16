package org.danduk.oauth2.facade.controller;


import org.danduk.oauth2.domain.LayerService;
import org.danduk.oauth2.gen.api.LayerApiDelegate;
import org.danduk.oauth2.gen.model.Layer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

import java.lang.invoke.MethodHandles;

@Component
public class LayerApiDelegateBean  implements LayerApiDelegate {
    static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final LayerService layerService;

    @Autowired
    public LayerApiDelegateBean(LayerService layerService) {
        this.layerService = layerService;
    }

    @Override
    public ResponseEntity<Layer> layerGetById(Integer id){
        //final var responseBody = new ResponseEntity<>();
        try {
            return new ResponseEntity<>(layerService.findLayerById(id), HttpStatus.OK);
        }
        catch (final NotFoundException e){
            logger.error(e.toString());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
