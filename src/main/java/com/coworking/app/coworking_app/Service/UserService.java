package com.coworking.app.coworking_app.Service;

import com.coworking.app.coworking_app.Dto.CoworkingDto;
import com.coworking.app.coworking_app.Dto.UserDto;
import com.coworking.app.coworking_app.Model.Coworking;
import com.coworking.app.coworking_app.Model.User;
import com.coworking.app.coworking_app.Repository.CoworkingRepo;
import com.coworking.app.coworking_app.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepo userRepository;
    private final CoworkingRepo coworkingRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepo userRepository, CoworkingRepo coworkingRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.coworkingRepository = coworkingRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserDto(user.getName(), user.getSurname(), user.getRole()))
                .collect(Collectors.toList());
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(int id, User updatedUser) {
        User existingUser = getUserById(id);
        existingUser.setName(updatedUser.getName());
        existingUser.setSurname(updatedUser.getSurname());
        if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
            existingUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        }
        return userRepository.save(existingUser);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public void bookingCoworkingPlace(CoworkingDto coworkingDto) {
        System.out.println("Бронирование места: " + coworkingDto.getWorkSpaceName());
    }


    public List<CoworkingDto> getUserReservations(int userId) {
        User user = getUserById(userId);
        return user.getReservations().stream()
                .map(coworking -> new CoworkingDto(
                        coworking.getId(),
                        coworking.getWorkSpaceName(),
                        coworking.getAmountOfRooms(),
                        coworking.getReservationTime(),
                        userId))
                .collect(Collectors.toList());
    }

    @Transactional
    public void cancelReservation(int coworkingId) {
        Coworking coworking = coworkingRepository.findById(coworkingId)
                .orElseThrow(() -> new RuntimeException("Coworking not found"));
        coworking.setUser(null);
        coworkingRepository.save(coworking);
    }
}
