package com.conectaedu.api.modules.university.service;

import com.conectaedu.api.modules.university.domain.University;
import com.conectaedu.api.modules.university.dto.request.UniversityUpdateRequestDTO;
import com.conectaedu.api.modules.university.dto.response.UniversityResponseDTO;
import com.conectaedu.api.modules.university.repository.UniversityRepository;
import com.conectaedu.api.shared.exceptions.UniversityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UniversityUpdateService {

    private final UniversityRepository universityRepository;

    @Transactional
    public UniversityResponseDTO updateUniversity(UUID id, UniversityUpdateRequestDTO request) {
        University university = universityRepository.findById(id)
                .orElseThrow(() -> new UniversityNotFoundException("Universidade não encontrada!"));

        university.setName(request.name());
        university.setCoordinator(request.coordinator());
        university.setAddress(request.address());



        universityRepository.save(university);
        return new UniversityResponseDTO(university);
    }
}