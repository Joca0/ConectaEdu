package com.conectaedu.api.modules.user.interfaces;

import com.conectaedu.api.modules.user.dto.request.UserCreationRequestDTO;
import com.conectaedu.api.modules.user.dto.request.UserUpdateRequestDTO;
import com.conectaedu.api.modules.user.dto.response.UserCreationResponseDTO;
import com.conectaedu.api.modules.user.dto.response.UserResponseDTO;

import java.util.List;
import java.util.UUID;

public interface IUserFacade {
    UserCreationResponseDTO createUser(UserCreationRequestDTO request);
    UserResponseDTO updateUser(UUID id, UserUpdateRequestDTO request);
    void deleteUser(UUID id);
    UserResponseDTO getUserById(UUID id);
    UserResponseDTO getUserByEmail(String email);
    List<UserResponseDTO> getAllUsers();
}
