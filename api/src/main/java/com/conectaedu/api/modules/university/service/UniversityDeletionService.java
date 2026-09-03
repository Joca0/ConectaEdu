package com.conectaedu.api.modules.university.service;

import com.conectaedu.api.modules.university.domain.University;
import com.conectaedu.api.modules.university.repository.UniversityRepository;
import com.conectaedu.api.shared.exceptions.UniversityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UniversityDeletionService {

    private final UniversityRepository universityRepository;

    @Transactional
    public void deleteUniversity(UUID id) {
        University university = universityRepository.findById(id)
                .orElseThrow(() -> new UniversityNotFoundException("Universidade não encontrada!"));
        universityRepository.save(university);
    }
}
