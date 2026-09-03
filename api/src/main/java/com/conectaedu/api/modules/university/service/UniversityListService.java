package com.conectaedu.api.modules.university.service;

import com.conectaedu.api.modules.university.dto.response.UniversityResponseDTO;
import com.conectaedu.api.modules.university.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversityListService {

    private final UniversityRepository universityRepository;

    @Transactional(readOnly = true)
    public List<UniversityResponseDTO> listAll() {
        return universityRepository.findAll()
                .stream()
                .map(UniversityResponseDTO::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<UniversityResponseDTO> listActive() {
        return universityRepository.findByActiveTrueOrderByNameAsc()
                .stream()
                .map(UniversityResponseDTO::new)
                .toList();
    }
}

