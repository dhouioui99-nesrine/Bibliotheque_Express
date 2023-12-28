package com.example.express.Service;

import java.util.List;

import com.example.express.Entity.User;
import com.example.express.dto.UserDto;

public interface UserService {
   void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}