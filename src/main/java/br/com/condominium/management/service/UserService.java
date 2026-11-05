package br.com.condominium.management.service;

import br.com.condominium.management.dto.UserRequestDTO;
import br.com.condominium.management.dto.UserResponseDTO;
import br.com.condominium.management.model.User;
import br.com.condominium.management.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

    private final UserRepository userRepository;

    // Injeção de dependências via construtor
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    // Método de criação de novo usuário
    public UserResponseDTO createUser(UserRequestDTO userDTO) {
        User user = new User();

        // Converte DTO para entidade
        user.setName(userDTO.name());
        user.setEmail(userDTO.email());
        user.setAddress(userDTO.address());
        user.setProfile(userDTO.profile());
        user.setStatus(userDTO.status());
        user.setCreatedAt(userDTO.createdAt());

        // Salvar no banco de dados
        User savedUser = userRepository.save(user);

        // Converte entidade para DTO de resposta
        return new UserResponseDTO(
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getAddress(),
                savedUser.getProfile(),
                savedUser.getStatus(),
                savedUser.getCreatedAt()
        );
    }
}
