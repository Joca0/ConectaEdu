package com.conectaedu.api.modules.school.service;

import com.conectaedu.api.modules.school.repository.SchoolRepository;
import com.conectaedu.api.shared.exceptions.SchoolNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SchoolDeletionService {

    private final SchoolRepository schoolRepository;

    public void deleteSchool(UUID id) {
        if (!schoolRepository.existsById(id)) {
            throw new SchoolNotFoundException("Escola não encontrada!");
        }
        schoolRepository.deleteById(id);
    }
}
