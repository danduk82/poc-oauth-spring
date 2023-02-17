package org.danduk.oauth2.domain.mapper;

import org.danduk.oauth2.gen.model.Server;
import org.danduk.oauth2.integration.persistence.entities.ServerEntity;

public class ServerMapper {
    public static Server serverEntityToServer(final ServerEntity serverEntity){
        final var server = new Server();
        server.setId((int) serverEntity.getId());
        server.setTitle(serverEntity.getTitle());
        server.setServerurl(server.getServerurl());
        server.setOgcprotocol(serverEntity.getOgcprotocol()); //todo: change type to ogcprotocol
        return server;
    }
}
