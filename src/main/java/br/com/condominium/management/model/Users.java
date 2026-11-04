package br.com.condominium.management.model;

import br.com.condominium.management.enums.UserProfile;
import br.com.condominium.management.enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "USERS")
@JsonPropertyOrder({"id"})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID", nullable = false)
    private UUID id;

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "EMAIL", nullable = false, length = 100)
    private String email;

    @Column(name = "ADDRESS", nullable = false, length = 200)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "PROFILE", nullable = false, length = 30)
    private UserProfile profile;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false, length = 30)
    private UserStatus status;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDate createdAt;

    @PrePersist
    public void PrePersist() {
        createdAt = LocalDate.now();
    }
}
