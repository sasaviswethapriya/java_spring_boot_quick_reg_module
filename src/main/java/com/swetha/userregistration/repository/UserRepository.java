package com.swetha.userregistration.repository;

import com.swetha.userregistration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
