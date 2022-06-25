package com.codegym.validateformdangky.repository;

import com.codegym.validateformdangky.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
