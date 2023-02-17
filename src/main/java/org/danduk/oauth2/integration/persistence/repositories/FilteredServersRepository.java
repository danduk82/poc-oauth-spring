package org.danduk.oauth2.integration.persistence.repositories;

import org.danduk.oauth2.integration.persistence.entities.views.FilteredServersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilteredServersRepository extends JpaRepository<FilteredServersEntity, Long> {
    boolean existsById(Long id);

    List<FilteredServersEntity> findFilteredServersEntitiesByUserEmail(String userEmail);

}
