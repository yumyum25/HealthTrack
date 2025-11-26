package com.example.healthtrack.service;

import com.example.healthtrack.dto.UserDTO;
import com.example.healthtrack.entity.User;
import com.example.healthtrack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User register(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setAge(userDTO.getAge());
        user.setGender(userDTO.getGender());
        return userRepository.save(user);
    }
}
