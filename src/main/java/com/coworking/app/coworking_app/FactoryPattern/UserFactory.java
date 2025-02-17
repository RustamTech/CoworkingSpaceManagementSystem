package com.coworking.app.coworking_app.FactoryPattern;

import com.coworking.app.coworking_app.Model.Role;
import com.coworking.app.coworking_app.Model.User;
import org.springframework.stereotype.Component;

@Component
public class UserFactory {
    public User createUser(String name, String surname, Role role){
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setRole(role);
        return user;
    }
}
