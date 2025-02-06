package com.coworking.app.coworking_app.Repository;

import com.coworking.app.coworking_app.Model.Coworking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoworkingRepo extends JpaRepository<Coworking, Integer> {
}
