package com.example.express.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.express.Entity.User;



public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}