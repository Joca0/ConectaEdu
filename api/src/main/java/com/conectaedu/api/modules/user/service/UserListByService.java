package com.conectaedu.api.modules.user.service;

import com.conectaedu.api.modules.user.domain.User;
import com.conectaedu.api.modules.user.dto.response.UserResponseDTO;
import com.conectaedu.api.modules.user.repository.UserRepository;
import com.conectaedu.api.shared.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserListByService {

    private final UserRepository userRepository;

    public UserResponseDTO listById(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado!"));
        return new UserResponseDTO(user);
    }

    public UserResponseDTO listByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado!"));
        return new UserResponseDTO(user);
    }
}
