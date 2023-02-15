package org.danduk.oauth2.integration.persistence.repositories;

import org.danduk.oauth2.integration.persistence.entities.BindingsEntity;
import org.danduk.oauth2.integration.persistence.entities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BindingsRepository extends JpaRepository<BindingsEntity, Long> {
    boolean existsById(Long id);
}
