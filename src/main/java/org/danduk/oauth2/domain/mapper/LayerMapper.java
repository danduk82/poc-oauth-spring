package org.danduk.oauth2.domain.mapper;

import org.danduk.oauth2.gen.model.Layer;
import org.danduk.oauth2.integration.persistence.entities.LayerEntity;

public class LayerMapper {
    public static Layer layerEntityToLayer(final LayerEntity layerEntity){
        final var layer = new Layer();
        layer.setId((int) layerEntity.getId());
        layer.setName(layerEntity.getName());
        layer.setMatrixset(layerEntity.getMatrixset());
        layer.setQueriable(layerEntity.getQueriable());
        layer.setTitle(layerEntity.getTitle());
        layer.setServerid(layerEntity.getFkServerId().intValue());
        return layer;
    }
}
