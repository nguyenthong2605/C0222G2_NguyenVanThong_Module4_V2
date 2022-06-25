package com.codegym.validateformdangky.service;

import com.codegym.validateformdangky.model.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUser();

    User save(User user);
}
