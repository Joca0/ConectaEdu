package com.conectaedu.api.modules.school.service;

import com.conectaedu.api.modules.school.domain.School;
import com.conectaedu.api.modules.school.dto.request.SchoolCreationRequestDTO;
import com.conectaedu.api.modules.school.dto.response.SchoolCreationResponseDTO;
import com.conectaedu.api.modules.school.repository.SchoolRepository;
import com.conectaedu.api.shared.exceptions.AddressAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SchoolCreationService {


    private final SchoolRepository schoolRepository;

    public SchoolCreationResponseDTO createSchool(SchoolCreationRequestDTO request) {
        if (schoolRepository.existsByAddress(request.address())) {
            throw new AddressAlreadyExistsException("Endereço já cadastrado");
        }
        School school = new School();

        school.setName(request.name());

        school.setDirector(request.director());

        school.setAddress(request.address());

        schoolRepository.save(school);
        return new SchoolCreationResponseDTO("Escola cadastrada com sucesso!");
    }

}
