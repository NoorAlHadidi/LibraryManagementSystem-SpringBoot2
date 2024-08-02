package com.brightskies.hotelsystem.Repository;

import com.brightskies.hotelsystem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByEmailOrPhone(String email, String phone);
}
