package com.kameleoon.service;

import com.kameleoon.model.User;
import com.kameleoon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import java.sql.SQLException;

@Service
public class UserService implements ServiceCommon<User> {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) throws SQLException {
        return userRepository.save(user);
    }
    public User findByEmail(@NotBlank String email) throws SQLException {
        return userRepository.findByEmail(email);
    }
}
