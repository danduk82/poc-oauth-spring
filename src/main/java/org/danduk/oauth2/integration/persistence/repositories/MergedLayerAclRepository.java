package org.danduk.oauth2.integration.persistence.repositories;

import org.danduk.oauth2.integration.persistence.entities.views.MergedLayerAclEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MergedLayerAclRepository extends JpaRepository<MergedLayerAclEntity, Long> {
    boolean existsById(Long id);

    List<MergedLayerAclEntity> findMergedLayerAclEntitiesByUserEmail(String userEmail);

}
