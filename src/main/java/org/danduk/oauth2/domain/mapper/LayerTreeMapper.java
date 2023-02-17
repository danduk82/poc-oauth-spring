package org.danduk.oauth2.domain.mapper;

import org.danduk.oauth2.gen.model.Layer;
import org.danduk.oauth2.gen.model.Server;
import org.danduk.oauth2.integration.persistence.entities.views.FilteredServersEntity;
import org.danduk.oauth2.integration.persistence.entities.views.MergedLayerAclEntity;


public class LayerTreeMapper {

    public static Server serverEntityToServer(FilteredServersEntity filteredServersEntity){
        Server server = new Server();
        server.setId(filteredServersEntity.getId().intValue());
        server.setTitle(filteredServersEntity.getTitle());
        server.setServerurl(filteredServersEntity.getUrl());
        server.setOgcprotocol(filteredServersEntity.getOgcprotocol());
        return server;
    }

    public static Layer layerEntityToLayer(final MergedLayerAclEntity mergedLayerAclEntity){
        final var layer = new Layer();
        layer.setId(mergedLayerAclEntity.getId().intValue());
        layer.setName(mergedLayerAclEntity.getName());
        layer.setMatrixset(mergedLayerAclEntity.getMatrixset());
        layer.setQueriable(mergedLayerAclEntity.getQueriable());
        layer.setTitle(mergedLayerAclEntity.getTitle());
        layer.setServerid(mergedLayerAclEntity.getFkServerId().intValue());
        return layer;
    }
}
