package org.danduk.oauth2.integration.persistence.repositories;

import org.danduk.oauth2.integration.persistence.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsById(Long id);
    boolean existsByEmail(String email);

    List<User> findByEmail(String email);
}
