package com.coworking.app.coworking_app.Model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    @NotNull(message = "User's name cannot be null")
    @Size(min = 1, max = 12, message = "User's name length should be between 1 and 12")
    @Schema(description = "User's name", example = "Rustam")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "User's surname cannot be null")
    @Size(min = 1, max = 12, message = "User's surname length should be between 1 and 12")
    @Schema(description = "User's surname", example = "Ismayilov")
    private String surname;

    @Column(nullable = false, unique = true)
    @NotNull(message = "User's password cannot be null")
    @Size(min = 8, max = 20, message = "User's password should be between 8 and 20 characters")
    @Schema(description = "User's password", example = "21dfdfdfd")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Coworking> reservations = new ArrayList<>();
}
