package com.coworking.app.coworking_app.Model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity

@Table(name = "reservations")
public class Coworking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "Reservation's name cannot be null")
    @Size(min = 1, max = 15, message = "Reservation's name should be between 1 and 15 characters")
    @Schema(description = "Name of coworking place", example = "Red Office")
    private String workSpaceName;

    @Column(nullable = false)
    @Min(value = 1, message = "Amount of rooms must be at least 1")
    @Schema(description = "Amount of rooms", example = "4")
    private int amountOfRooms;

    @Column(nullable = false)
    private LocalDateTime reservationTime;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(optional = true)
    @JoinColumn(name = "admin_id")
    private Admin admin;

    public Coworking(String workSpaceName, int amountOfRooms, LocalDateTime reservationTime, User user, Admin admin) {
        this.workSpaceName = workSpaceName;
        this.amountOfRooms = amountOfRooms;
        this.reservationTime = reservationTime;
        this.user = user;
        this.admin = admin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorkSpaceName() {
        return workSpaceName;
    }

    public void setWorkSpaceName(String workSpaceName) {
        this.workSpaceName = workSpaceName;
    }

    public int getAmountOfRooms() {
        return amountOfRooms;
    }

    public void setAmountOfRooms(int amountOfRooms) {
        this.amountOfRooms = amountOfRooms;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalDateTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
