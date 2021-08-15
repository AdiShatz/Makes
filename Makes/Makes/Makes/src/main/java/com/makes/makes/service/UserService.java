package com.makes.makes.service;


import com.makes.makes.model.User;
import com.makes.makes.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void add(User user)
    {
        userRepository.insert(user);
    }


    public Optional<User> findByEmail(String userEmail)
    {
       return userRepository.findUserByEmail(userEmail);
    }

    public User findById(String userId)
    {
        return userRepository.findUserById(userId);
    }



}
