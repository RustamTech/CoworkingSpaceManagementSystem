package com.coworking.app.coworking_app.Controller;

import com.coworking.app.coworking_app.Dto.CoworkingDto;
import com.coworking.app.coworking_app.Model.User;
import com.coworking.app.coworking_app.Service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.coworking.app.coworking_app.Dto.UserDto;

import java.util.List;

@RestController
@RequestMapping("/user")
@Tag(name = "User Management", description = "Operation related to user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setRole(userDto.getRole());
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }



    @GetMapping("/all")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/reservation")
    public ResponseEntity<String> bookingCoworkingPlace(@RequestBody CoworkingDto coworkingDto) {
        userService.bookingCoworkingPlace(coworkingDto);
        return ResponseEntity.ok("You have successfully booked the place");
    }

    @DeleteMapping("/cancel/{coworkingId}")
    public ResponseEntity<String> cancelReservation(@PathVariable int coworkingId) {
        userService.cancelReservation(coworkingId);
        return ResponseEntity.ok("Reservation cancelled successfully");
    }


    @GetMapping("/reservations/{userId}")
    public ResponseEntity<List<CoworkingDto>> getUsersReservations(@PathVariable int userId) {
        List<CoworkingDto> reservations = userService.getUserReservations(userId);
        return ResponseEntity.ok(reservations);
    }
}
