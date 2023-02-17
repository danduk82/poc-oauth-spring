package org.danduk.oauth2.facade.controller;


import org.danduk.oauth2.domain.LayerTreeService;
import org.danduk.oauth2.gen.api.LayertreeApiDelegate;
import org.danduk.oauth2.gen.model.Layertree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.StandardClaimAccessor;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;
import org.webjars.NotFoundException;

import java.lang.invoke.MethodHandles;

@Component
public class LayerTreeApiDelegateBean implements LayertreeApiDelegate {
    static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final LayerTreeService layerTreeService;
    private NativeWebRequest request;

    @Autowired
    public LayerTreeApiDelegateBean(NativeWebRequest request, LayerTreeService layerTreeService) {
        this.request = request;
        this.layerTreeService = layerTreeService;
    }

    @Override
    public ResponseEntity<Layertree> layertreeGet(){

        String userEmail;
        java.security.Principal userPrincipal = this.request.getUserPrincipal();
        if(userPrincipal instanceof OAuth2AuthenticationToken) {
            OAuth2User oauth2user = ((OAuth2AuthenticationToken)userPrincipal).getPrincipal();
            if(oauth2user instanceof StandardClaimAccessor) {
                userEmail = ((StandardClaimAccessor)oauth2user).getEmail();
            }else {
                userEmail = oauth2user.getAttribute("email");
            }
        } else {
            throw new IllegalStateException("Unsupported token type: " + userPrincipal==null?"null":userPrincipal.getClass().getName());
        }
        logger.info("serving layertree for user : %s".formatted(userEmail));
        try {
            return new ResponseEntity<>(layerTreeService.createLayerTreeByEmail(userEmail), HttpStatus.OK);
        }
        catch (final NotFoundException e){
            logger.error(e.toString());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
