package com.spring.mappers;

import com.spring.dto.RegisterUserDTO;
import com.spring.dto.UserDTO;
import com.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.spring.repository.UserRepo;

import java.util.UUID;

public class UserMapper {

    public static UserDTO convertToUserDTO(User user) {
        UserDTO userDto = new UserDTO();
        userDto.setAddress(user.getAddress());
        userDto.setConfirmed(user.isConfirmed());
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setId(user.getId());
        userDto.setPassword(user.getPassword());
        userDto.setImage(user.getImage());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setTickets(user.getTickets());
        return userDto;
    }

    public static User dtoToEntity(UserDTO userDTO) {
        User user = new User();
        return user;
    }

    public static User registerUserDTOToEntity(RegisterUserDTO registerUserDTO) {
        User newUser = new User();
        newUser.setFirstName(registerUserDTO.getFirstName());
        newUser.setLastName(registerUserDTO.getLastName());
        newUser.setAddress(registerUserDTO.getAddress());
        newUser.setPhoneNumber(registerUserDTO.getPhoneNumber());
        newUser.setEmail(registerUserDTO.getEmail());
        newUser.setPassword(registerUserDTO.getPassword());
        newUser.setImage(registerUserDTO.getImage());

        newUser.setId(UUID.randomUUID().toString());
        newUser.setConfirmed(false);
        return newUser;
    }
}
