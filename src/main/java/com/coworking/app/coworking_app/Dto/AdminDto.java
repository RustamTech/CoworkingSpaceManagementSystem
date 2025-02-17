package com.coworking.app.coworking_app.Dto;

import com.coworking.app.coworking_app.Model.Admin;
import com.coworking.app.coworking_app.Model.Role;
import lombok.*;

@Data
public class AdminDto {
    private Long id;
    private String name;
    private String surname;
    private Role role;

    public AdminDto(Admin admin) {
        this.name = admin.getName();
        this.surname = admin.getSurname();
        this.role = admin.getRole();
    }
}
