package com.perpro.rest.services.user.service;

import com.perpro.rest.services.user.models.User;
import com.perpro.rest.services.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserById(UUID userId) {
        return userRepository.findById(userId).get();
    }
}
