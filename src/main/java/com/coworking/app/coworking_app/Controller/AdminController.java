package com.coworking.app.coworking_app.Controller;

import com.coworking.app.coworking_app.Dto.AdminDto;
import com.coworking.app.coworking_app.Dto.CoworkingDto;
import com.coworking.app.coworking_app.Dto.UserDto;
import com.coworking.app.coworking_app.Service.AdminService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@Tag(name = "Admin Management", description = "Operation related to admin ")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @PostMapping("register-admin")
    public ResponseEntity<AdminDto> registerAdmin(@RequestBody AdminDto adminDto){
        return ResponseEntity.ok(adminService.registerAdmin(adminDto));
    }

    @PostMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        adminService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto){
        return ResponseEntity.ok(adminService.updateUser(id, userDto));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(adminService.getAllUsers());
    }

    @GetMapping("/places")
    public ResponseEntity<List<CoworkingDto>> getAllCoworkingPlaces(){
        return ResponseEntity.ok(adminService.getAllCoworkingPlaces());
    }
}

