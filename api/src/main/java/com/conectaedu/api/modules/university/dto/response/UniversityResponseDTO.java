package com.conectaedu.api.modules.university.dto.response;

import com.conectaedu.api.modules.university.domain.University;
import com.conectaedu.api.shared.domain.Address;

import java.util.Set;
import java.util.UUID;

public record UniversityResponseDTO(
        UUID id,
        String name,
        String cnpj,
        String coordinator,
        Set<String> courses,
        AddressDTO address,
        String logoUrl,
        boolean active
) {

    public UniversityResponseDTO(University university) {
        this(university.getId(),
                university.getName(),
                university.getCnpj(),
                university.getCoordinator(),
                university.getCourses(),
                AddressDTO.from(university.getAddress()),
                university.getLogoUrl(),
                university.isActive());
    }

    public record AddressDTO(
            String street,
            String number,
            String district,
            String city,
            String state,
            String zipCode
    ) {
        static AddressDTO from(Address address) {
            if (address == null) {
                return null;
            }
            return new AddressDTO(address.street(), address.number(), address.district(),
                    address.city(), address.state(), address.zipCode());
        }
    }
}
