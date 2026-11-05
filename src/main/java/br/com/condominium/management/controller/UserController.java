package br.com.condominium.management.controller;

import br.com.condominium.management.dto.UserRequestDTO;
import br.com.condominium.management.dto.UserResponseDTO;
import br.com.condominium.management.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // Injeção de dependências via construtor
    public UserController(UserService userService) {
        this.userService = userService;
    }


    // Método para cadastrar um novo usuário
    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO userDTO) {
        UserResponseDTO responseDTO = userService.createUser(userDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}
