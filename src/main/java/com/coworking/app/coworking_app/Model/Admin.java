package com.coworking.app.coworking_app.Model;

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

@Table(name = "admins")
public class Admin {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Coworking> getApprovedReservations() {
        return approvedReservations;
    }

    public void setApprovedReservations(List<Coworking> approvedReservations) {
        this.approvedReservations = approvedReservations;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "Admin's name cannot be null")
    @Size(min = 1, max = 12, message = "Admin's name length should be between 1 and 12")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "Admin's surname cannot be null")
    @Size(min = 1, max = 12, message = "Admin's surname length should be between 1 and 12")
    private String surname;

    @Column(nullable = false, unique = true)
    @NotNull(message = "Admin's password cannot be null")
    @Size(min = 8, max = 20, message = "Admin's password should be between 8 and 20 characters")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Coworking> approvedReservations = new ArrayList<>();

    public Admin(String name, String surname, String password, Role role) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.role = role;
    }
}

