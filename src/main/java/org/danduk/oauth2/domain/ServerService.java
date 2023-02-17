package org.danduk.oauth2.domain;

import org.danduk.oauth2.domain.mapper.ServerMapper;
import org.danduk.oauth2.gen.model.Server;
import org.danduk.oauth2.integration.persistence.entities.ServerEntity;
import org.danduk.oauth2.integration.persistence.repositories.ServerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.lang.invoke.MethodHandles;

@Service
public class ServerService {
    static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final ServerRepository serverRepository;

    @Autowired
    public ServerService(final ServerRepository serverRepository) {
        this.serverRepository = serverRepository;
    }
    public Server findServerById(final long id) throws NotFoundException {
        return serverRepository.findById(id).map(ServerMapper::serverEntityToServer)
                .orElseThrow(
                        () -> new NotFoundException("not found: %s with id = %s".formatted(ServerEntity.class.getSimpleName(), String.valueOf(id))));
    }
}
