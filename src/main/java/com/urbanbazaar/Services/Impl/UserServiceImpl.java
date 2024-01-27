package com.urbanbazaar.Services.Impl;

import com.urbanbazaar.DTO.UserDto;
import com.urbanbazaar.Entities.User;
import com.urbanbazaar.Exceptions.CustomResourceNotFoundException;
import com.urbanbazaar.Repo.UserRepo;
import com.urbanbazaar.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepo.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto user, long userId) {
        User existingUser = userRepo.findById(userId)
                .orElseThrow(() -> new CustomResourceNotFoundException("User not found with id: " + userId));

        existingUser.setName(user.getName());
        existingUser.setAddress(user.getAddress());
        existingUser.setMobile(user.getMobile());
        existingUser.setState(user.getState());
        existingUser.setCartCount(user.getCartCount());
        existingUser.setItemsInCart(user.getItemsInCart());
        User updatedUser = userRepo.save(existingUser);
        return userToDto(updatedUser);
    }

    @Override
    public UserDto getUserById(long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new CustomResourceNotFoundException("User not found with id: " + userId));
        return userToDto(user);
    }

    @Override
    public void deleteUser(long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new CustomResourceNotFoundException("User not found with id: " + userId));
        userRepo.delete(user);
    }


    private User dtoToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setAddress(userDto.getAddress());
        user.setMobile(userDto.getMobile());
        user.setState(userDto.getState());
        user.setCartCount(userDto.getCartCount());
        user.setItemsInCart(userDto.getItemsInCart());
        return user;
    }
    private UserDto userToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setAddress(user.getAddress());
        userDto.setMobile(user.getMobile());
        userDto.setState(user.getState());
        userDto.setCartCount(user.getCartCount());
        userDto.setItemsInCart(user.getItemsInCart());
        return userDto;
    }
}
