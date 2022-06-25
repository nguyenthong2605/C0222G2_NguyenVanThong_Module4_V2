package com.codegym.validateformdangky.service;

import com.codegym.validateformdangky.model.User;
import com.codegym.validateformdangky.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public List<User> getAllUser() {
        return iUserRepository.findAll();
    }

    @Override
    public User save(User user) {
        return iUserRepository.save(user);
    }
}
