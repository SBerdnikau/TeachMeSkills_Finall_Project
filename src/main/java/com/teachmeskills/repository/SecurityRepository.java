package com.teachmeskills.repository;

import com.teachmeskills.model.Security;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SecurityRepository extends JpaRepository<Security, Long> {
    Boolean existsByLogin(String login);

    Optional<Security> findByLogin(String login);
}
