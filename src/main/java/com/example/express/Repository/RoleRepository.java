package com.example.express.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.express.Entity.Role;



public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
