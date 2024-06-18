package com.assessment.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment.user_service.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {

    boolean existsByUsername(String username);

}
