package com.proyecto.proyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.proyecto.modelos.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {   
    public User findByName(String name);
}
