package com.conectaedu.api.modules.university.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressDTO(

        @NotBlank(message = "Logradouro é obrigatório")
        String street,

        String number,

        String district,

        @NotBlank(message = "Cidade é obrigatória")
        String city,

        @Pattern(regexp = "[A-Z]{2}", message = "UF deve ter 2 letras maiúsculas")
        String state,

        @Pattern(regexp = "\\d{8}", message = "CEP deve ter 8 dígitos, sem máscara")
        String zipCode
) {
}