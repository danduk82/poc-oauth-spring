package org.danduk.oauth2.domain;

import org.danduk.oauth2.domain.mapper.LayerMapper;
import org.danduk.oauth2.domain.mapper.LayerTreeMapper;
import org.danduk.oauth2.gen.model.Layer;
import org.danduk.oauth2.gen.model.Layertree;
import org.danduk.oauth2.gen.model.Server;
import org.danduk.oauth2.integration.persistence.entities.LayerEntity;
import org.danduk.oauth2.integration.persistence.entities.views.FilteredServersEntity;
import org.danduk.oauth2.integration.persistence.repositories.FilteredServersRepository;
import org.danduk.oauth2.integration.persistence.repositories.LayerRepository;
import org.danduk.oauth2.integration.persistence.repositories.MergedLayerAclRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LayerTreeService {
    static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final FilteredServersRepository filteredServersRepository;
    private final MergedLayerAclRepository mergedLayerAclRepository;


    @Autowired
    public LayerTreeService(final FilteredServersRepository filteredServersRepository, MergedLayerAclRepository mergedLayerAclRepository) {
        this.filteredServersRepository = filteredServersRepository;
        this.mergedLayerAclRepository = mergedLayerAclRepository;
    }
    public List<Server> findServersByEmail(String userEmail) throws NotFoundException {
        List<Server> serverList = filteredServersRepository.findFilteredServersEntitiesByUserEmail(userEmail)
                .stream()
                .map(LayerTreeMapper::serverEntityToServer)
                .collect(Collectors.toList());
        if (serverList.isEmpty()){
            throw new NotFoundException("not found instance of %s allowed for email: %s".formatted(Server.class.getSimpleName(),userEmail));
        }
        return serverList;
    }

    public List<Layer> findLayersByEmail(String userEmail) throws NotFoundException {
        List<Layer> layerList = mergedLayerAclRepository.findMergedLayerAclEntitiesByUserEmail(userEmail)
                .stream()
                .map(LayerTreeMapper::layerEntityToLayer)
                .collect(Collectors.toList());
        if (layerList.isEmpty()){
            throw new NotFoundException("not found instance of %s allowed for email: %s".formatted(Layer.class.getSimpleName(),userEmail));
        }
        return layerList;
    }

    public Layertree createLayerTreeByEmail(String userEmail) {
        Layertree layertree = new Layertree();
        layertree.setLayers(findLayersByEmail(userEmail));
        layertree.setServers(findServersByEmail(userEmail));
        return layertree;
    }
}
//