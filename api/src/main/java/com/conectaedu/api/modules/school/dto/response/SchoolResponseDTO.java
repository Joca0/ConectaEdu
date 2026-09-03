package com.conectaedu.api.modules.school.dto.response;

import com.conectaedu.api.modules.school.domain.School;

import java.util.UUID;

public record SchoolResponseDTO(
        UUID id,
        String name,
        String director,
        String address,
        Double latitude,
        Double longitude
) {
    public SchoolResponseDTO(School school) {
        this(school.getId(), school.getName(), school.getDirector(), school.getAddress(), school.getLatitude(), school.getLongitude());
    }
}
