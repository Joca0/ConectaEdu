package com.conectaedu.api.modules.university.dto.response;

import com.conectaedu.api.modules.university.domain.University;

import java.time.LocalDateTime;
import java.util.UUID;

public record UniversityResponseDTO(
        UUID id,
        String name,
        String cnpj,
        String coordinator,
        String address,
        LocalDateTime updatedAt

) {
    public UniversityResponseDTO(University university) {
        this(university.getId(), university.getName(), university.getCnpj(), university.getCoordinator(), university.getAddress(), university.getUpdatedAt());
    }
}
