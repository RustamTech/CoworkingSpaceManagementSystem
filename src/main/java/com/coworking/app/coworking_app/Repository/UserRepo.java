package com.coworking.app.coworking_app.Repository;

import com.coworking.app.coworking_app.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}
