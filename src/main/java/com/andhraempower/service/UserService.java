package com.andhraempower.service;

import com.andhraempower.dto.LoginRequestDto;
import com.andhraempower.dto.UserRequestDto;
import com.andhraempower.dto.UserResponseDto;
import com.andhraempower.entity.User;
import com.andhraempower.exception.InvalidCredentialsException;
import com.andhraempower.exception.UserAlreadyExistsException;
import com.andhraempower.exception.UserNotFoundException;
import com.andhraempower.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponseDto loadUserWithRoles(LoginRequestDto loginRequestDto) {
        Optional<User> userOptional = userRepository.findByUserName(loginRequestDto.getUserName());

        if (!userOptional.isPresent()) {
            throw new UserNotFoundException("User does not exist with username: " + loginRequestDto.getUserName());
        }

        User user = userOptional.get();

        if (!loginRequestDto.getPassword().equals(user.getPassword())) {
            throw new InvalidCredentialsException("Invalid credentials for user: " + loginRequestDto.getUserName());
        }
        return new UserResponseDto(user);
    }

    public User createUser(UserRequestDto userRequestDto) {

        if (userRepository.existsByUserName(userRequestDto.getUserName())) {
            throw new UserAlreadyExistsException("Username already exists. Please choose another one.");
        }

        if (userRepository.existsByEmail(userRequestDto.getEmail())) {
            throw new UserAlreadyExistsException("Email already exists. Please choose another one.");
        }


        User user = new User();
        user.setFirstName(userRequestDto.getFirstName());
        user.setLastName(userRequestDto.getLastName());
        user.setPhoneNumber(userRequestDto.getPhoneNumber());
        user.setEmail(userRequestDto.getEmail());
        user.setUserName(userRequestDto.getUserName());

        user.setPassword(userRequestDto.getPassword());

        return userRepository.save(user);
    }
}
