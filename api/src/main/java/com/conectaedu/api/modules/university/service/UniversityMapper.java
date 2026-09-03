package com.conectaedu.api.modules.university.service;

import com.conectaedu.api.modules.university.dto.request.AddressDTO;
import com.conectaedu.api.shared.domain.Address;

final class UniversityMapper {

    private UniversityMapper() {
    }

    static Address toAddress(AddressDTO dto) {
        if (dto == null) {
            return null;
        }
        return new Address(dto.street(), dto.number(), dto.district(),
                dto.city(), dto.state(), dto.zipCode());
    }
}
