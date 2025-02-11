package com.coworking.app.coworking_app.Dto;

import com.coworking.app.coworking_app.Model.Role;
import com.coworking.app.coworking_app.Model.User;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private Role role;

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.role = user.getRole();
    }
}
