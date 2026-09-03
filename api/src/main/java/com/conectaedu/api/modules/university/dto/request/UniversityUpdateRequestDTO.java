package com.conectaedu.api.modules.university.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record UniversityUpdateRequestDTO(

        @NotBlank(message = "Nome é obrigatório")
        String name,

        @NotBlank(message = "Coordenador é obrigatório")
        String coordinator,

        @NotEmpty(message = "Informe ao menos um curso")
        Set<String> courses,

        @NotNull(message = "Endereço é obrigatório")
        @Valid
        AddressDTO address,

        String logoUrl
) {
}
