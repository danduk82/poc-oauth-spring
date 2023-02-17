package org.danduk.oauth2.domain;

import org.danduk.oauth2.domain.mapper.AclMapper;
import org.danduk.oauth2.gen.model.Acl;
import org.danduk.oauth2.integration.persistence.entities.AclEntity;
import org.danduk.oauth2.integration.persistence.repositories.AclRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.lang.invoke.MethodHandles;

@Service
public class AclService {
    static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final AclRepository aclRepository;

    @Autowired
    public AclService(final AclRepository aclRepository) {
        this.aclRepository = aclRepository;
    }
    public Acl findAclById(final long id) throws NotFoundException {
        return aclRepository.findById(id).map(AclMapper::aclEntityToAcl)
                .orElseThrow(
                        () -> new NotFoundException("not found: %s with id = %s".formatted(AclEntity.class.getSimpleName(), String.valueOf(id))));
    }
}
