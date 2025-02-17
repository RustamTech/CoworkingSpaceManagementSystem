package com.coworking.app.coworking_app.Dto;

import com.coworking.app.coworking_app.Model.Admin;
import com.coworking.app.coworking_app.Model.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDto {
    private Long id;
    private String name;
    private String surname;
    private String password;
    private Role role;

    public AdminDto(Admin admin) {
        this.id = admin.getId();
        this.name = admin.getName();
        this.surname = admin.getSurname();
        this.password = admin.getPassword();
        this.role = admin.getRole();
    }
}
