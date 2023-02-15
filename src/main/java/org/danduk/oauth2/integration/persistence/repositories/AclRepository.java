package org.danduk.oauth2.integration.persistence.repositories;

import org.danduk.oauth2.integration.persistence.entities.AclEntity;
import org.danduk.oauth2.integration.persistence.entities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AclRepository extends JpaRepository<AclEntity, Long> {
    boolean existsById(Long id);

}
