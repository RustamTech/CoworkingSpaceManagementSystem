package com.coworking.app.coworking_app.Dto;

import com.coworking.app.coworking_app.Model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class UserDto {
    private int id;
    private String name;
    private String surname;
    private Role role;

    public UserDto(String name, String surname, Role role) {
        this.name = name;
        this.surname = surname;
        this.role = role;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
