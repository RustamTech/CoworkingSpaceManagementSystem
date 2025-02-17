package com.coworking.app.coworking_app.Controller;

import com.coworking.app.coworking_app.Dto.AdminDto;
import com.coworking.app.coworking_app.Dto.CoworkingDto;
import com.coworking.app.coworking_app.Dto.UserDto;
import com.coworking.app.coworking_app.Model.Admin;
import com.coworking.app.coworking_app.Service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Register a new admin")
    @PostMapping("register-admin")
    public ResponseEntity<AdminDto> registerAdmin(@RequestBody AdminDto adminDto, @RequestParam String password) {
        return ResponseEntity.ok(adminService.registerAdmin(adminDto, password));
    }

    @DeleteMapping("/users/{id}")
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

    @GetMapping("/admins")
    public ResponseEntity<List<AdminDto>> getAllAdmins(){
        return ResponseEntity.ok(adminService.getAllAdmins());
    }
    @GetMapping("/places")
    public ResponseEntity<List<CoworkingDto>> getAllCoworkingPlaces(){
        return ResponseEntity.ok(adminService.getAllCoworkingPlaces());
    }
}

