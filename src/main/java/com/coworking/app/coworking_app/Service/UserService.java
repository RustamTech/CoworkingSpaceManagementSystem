package com.coworking.app.coworking_app.Service;

import com.coworking.app.coworking_app.Dto.CoworkingDto;
import com.coworking.app.coworking_app.Dto.UserDto;
import com.coworking.app.coworking_app.Model.Coworking;
import com.coworking.app.coworking_app.Model.User;
import com.coworking.app.coworking_app.Repository.CoworkingRepo;
import com.coworking.app.coworking_app.Repository.UserRepo;
import com.coworking.app.coworking_app.Exception.CoworkingNotFoundException;
import com.coworking.app.coworking_app.Exception.UserNotFoundException;
import com.coworking.app.coworking_app.Exception.ReservationNotFoundException;
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
        return userRepository.findAll().stream()
                .map(UserDto::new)
                .collect(Collectors.toList());
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public User updateUser(Long id, User updatedUser) {
        User existingUser = getUserById(id);
        existingUser.setName(updatedUser.getName());
        existingUser.setSurname(updatedUser.getSurname());
        if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
            existingUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        }
        return userRepository.save(existingUser);
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public void bookingCoworkingPlace(CoworkingDto coworkingDto) {
        System.out.println("Бронирование места: " + coworkingDto.getWorkSpaceName());
    }

    public List<CoworkingDto> getUserReservations(Long userId) {
        User user = getUserById(userId);
        if (user.getReservations().isEmpty()) {
            throw new ReservationNotFoundException(userId);
        }
        return user.getReservations().stream()
                .map(CoworkingDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void cancelReservation(Long coworkingId) {
        Coworking coworking = coworkingRepository.findById(coworkingId)
                .orElseThrow(() -> new CoworkingNotFoundException(coworkingId));
        coworking.setUser(null);
        coworkingRepository.save(coworking);
    }
}
