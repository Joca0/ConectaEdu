package com.conectaedu.api.modules.university.service;

import com.conectaedu.api.modules.university.domain.University;
import com.conectaedu.api.modules.university.dto.request.UniversityCreationRequestDTO;
import com.conectaedu.api.modules.university.dto.response.UniversityCreationResponseDTO;
import com.conectaedu.api.modules.university.repository.UniversityRepository;
import com.conectaedu.api.shared.exceptions.CnpjAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UniversityCreationService {

    private final UniversityRepository universityRepository;

    @Transactional
    public UniversityCreationResponseDTO createUniversity(UniversityCreationRequestDTO request) {

        if (universityRepository.existsByCnpj(request.cnpj())) {
            throw new CnpjAlreadyExistsException("CNPJ já cadastrado!");
        }

        University university = new University(
                request.name(),
                request.cnpj(),
                request.coordinator(),
                UniversityMapper.toAddress(request.address()),
                request.logoUrl());

        university.replaceCourses(request.courses());
        universityRepository.save(university);

        return new UniversityCreationResponseDTO(
                university.getId(), "Universidade criada com sucesso!");
    }
}
