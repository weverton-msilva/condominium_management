package br.com.condominium.management.dto;

import br.com.condominium.management.enums.UserProfile;
import br.com.condominium.management.enums.UserStatus;

import java.time.LocalDate;

public record UserResponseDTO(
        String name,
        String email,
        String address,
        UserProfile profile,
        UserStatus status,
        LocalDate createdAt
) {}
