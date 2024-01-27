package com.urbanbazaar.Services;

import com.urbanbazaar.DTO.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto user, long userId);
    UserDto getUserById(long userId);
    void deleteUser(long userId);
}
