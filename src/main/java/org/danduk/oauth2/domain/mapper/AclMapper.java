package org.danduk.oauth2.domain.mapper;

import org.danduk.oauth2.gen.model.Acl;
import org.danduk.oauth2.integration.persistence.entities.AclEntity;

public class AclMapper {
    public static Acl aclEntityToAcl(final AclEntity aclEntity){
        final var acl = new Acl();
        acl.setId((int) aclEntity.getId());
        acl.setLayerId(aclEntity.getFkLayerId().intValue());
        acl.setRoleId(aclEntity.getFkRoleId().intValue());
        return acl;
    }
}
