package org.danduk.oauth2.domain;

import org.danduk.oauth2.domain.mapper.BindingsMapper;
import org.danduk.oauth2.gen.model.Bindings;
import org.danduk.oauth2.integration.persistence.entities.BindingsEntity;
import org.danduk.oauth2.integration.persistence.repositories.BindingsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.lang.invoke.MethodHandles;

@Service
public class BindingsService {
    static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final BindingsRepository bindingsRepository;

    @Autowired
    public BindingsService(final BindingsRepository bindingsRepository) {
        this.bindingsRepository = bindingsRepository;
    }
    public Bindings findBindingsById(final long id) throws NotFoundException {
        return bindingsRepository.findById(id).map(BindingsMapper::bindingsEntityToBindings)
                .orElseThrow(
                        () -> new NotFoundException("not found: %s with id = %s".formatted(BindingsEntity.class.getSimpleName(), String.valueOf(id))));
    }
}
