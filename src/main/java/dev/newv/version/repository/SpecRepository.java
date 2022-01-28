package dev.newv.version.repository;

import dev.newv.version.domain.Spec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecRepository extends JpaRepository<Spec, Long> {

    Spec findByName(String name);
}