package org.danduk.oauth2.domain;

import org.danduk.oauth2.domain.mapper.LayerMapper;
import org.danduk.oauth2.gen.model.Layer;
import org.danduk.oauth2.integration.persistence.entities.LayerEntity;
import org.danduk.oauth2.integration.persistence.repositories.LayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.lang.invoke.MethodHandles;

@Service
public class LayerService {
    static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final LayerRepository layerRepository;

    @Autowired
    public LayerService(final LayerRepository layerRepository) {
        this.layerRepository = layerRepository;
    }
    public Layer findLayerById(final long id) throws NotFoundException {
        return layerRepository.findById(id).map(LayerMapper::layerEntityToLayer)
                .orElseThrow(
                        () -> new NotFoundException("not found: %s with id = %s".formatted(LayerEntity.class.getSimpleName(), String.valueOf(id))));
    }
}
