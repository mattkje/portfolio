package no.mattikj.backend.repository;

import no.mattikj.backend.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}