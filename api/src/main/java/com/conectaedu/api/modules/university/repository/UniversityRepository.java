package com.conectaedu.api.modules.university.repository;

import com.conectaedu.api.modules.university.domain.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UniversityRepository extends JpaRepository<University, UUID> {

    Boolean existsByCnpj(String cnpj);

    Optional<University> findByCnpj(String cnpj);

    List<University> findByActiveTrueOrderByNameAsc();
}

