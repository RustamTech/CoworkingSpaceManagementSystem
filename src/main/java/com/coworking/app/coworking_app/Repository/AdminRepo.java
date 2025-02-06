package com.coworking.app.coworking_app.Repository;

import com.coworking.app.coworking_app.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer> {
}
