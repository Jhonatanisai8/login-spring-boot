package com.isai.login_spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isai.login_spring_boot.models.User;

@Repository
public interface UserRepository
        extends JpaRepository<User, Long> {

}