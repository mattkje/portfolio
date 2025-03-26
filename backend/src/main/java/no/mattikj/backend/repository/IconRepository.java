package no.mattikj.backend.repository;

import no.mattikj.backend.entity.Icon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IconRepository extends JpaRepository<Icon, Long> {
}