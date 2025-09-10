package com.example.card.manager.services;

import com.example.card.manager.domain.dto.UserDto;
import org.springframework.http.ResponseEntity;



public interface UserService {
    ResponseEntity<?> authenticateUser(UserDto userDto);

    ResponseEntity<?> registerUser(UserDto userDto);
}