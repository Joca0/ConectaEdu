package com.conectaedu.api.modules.school.interfaces;

import com.conectaedu.api.modules.school.dto.request.SchoolUpdateRequestDTO;
import com.conectaedu.api.modules.school.dto.response.SchoolCreationResponseDTO;
import com.conectaedu.api.modules.school.dto.response.SchoolResponseDTO;
import com.conectaedu.api.modules.school.dto.request.SchoolCreationRequestDTO;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface ISchoolFacade {
    SchoolCreationResponseDTO createSchool(@Valid SchoolCreationRequestDTO request);
    SchoolResponseDTO updateSchool(UUID schoolId, SchoolUpdateRequestDTO request);
    void deleteSchool(UUID id);
    SchoolResponseDTO getSchoolById(UUID id);
    SchoolResponseDTO getSchoolByAddress(String address);
    List<SchoolResponseDTO> getAllSchools();
}
