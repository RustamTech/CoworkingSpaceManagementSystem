package com.coworking.app.coworking_app.Service;

import com.coworking.app.coworking_app.Dto.AdminDto;
import com.coworking.app.coworking_app.Dto.CoworkingDto;
import com.coworking.app.coworking_app.Dto.UserDto;
import com.coworking.app.coworking_app.Exception.UserNotFoundException;
import com.coworking.app.coworking_app.Model.Admin;
import com.coworking.app.coworking_app.Model.User;
import com.coworking.app.coworking_app.Repository.AdminRepo;
import com.coworking.app.coworking_app.Repository.CoworkingRepo;
import com.coworking.app.coworking_app.Repository.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {

    private final UserRepo userRepo;
    private final AdminRepo adminRepo;
    private final CoworkingRepo coworkingRepo;
    private final PasswordEncoder passwordEncoder;

    public AdminService(UserRepo userRepo, AdminRepo adminRepo, CoworkingRepo coworkingRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.adminRepo = adminRepo;
        this.coworkingRepo = coworkingRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public AdminDto registerAdmin(AdminDto adminDto) {
        Admin admin = new Admin(adminDto.getName(), adminDto.getSurname(), passwordEncoder.encode(adminDto.getPassword()), adminDto.getRole());
        adminRepo.save(admin);
        return new AdminDto(admin);
    }

    public void deleteUser(Long id) {
        if (!adminRepo.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        adminRepo.deleteById(id);
    }

    public List<AdminDto> getAllAdmins() {
        return adminRepo.findAll().stream().map(AdminDto::new).collect(Collectors.toList());
    }

    public List<UserDto> getAllUsers() {
        return userRepo.findAll().stream().map(UserDto::new).collect(Collectors.toList());
    }

    public List<CoworkingDto> getAllCoworkingPlaces() {
        return coworkingRepo.findAll().stream().map(CoworkingDto::new).collect(Collectors.toList());
    }

    public UserDto updateUser(Long id, UserDto userDto) {
        User user = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setRole(userDto.getRole());
        userRepo.save(user);
        return new UserDto(user);
    }
}


