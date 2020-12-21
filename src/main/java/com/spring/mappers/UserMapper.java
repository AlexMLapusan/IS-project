package com.spring.mappers;

import com.spring.dto.UserDTO;
import com.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.spring.repository.UserRepo;

public class UserMapper {

    @Autowired
    UserRepo userRepo;

    public static UserDTO convertToUserDTO(User user){
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

    public static User dtoToEntity(UserDTO userDTO){
        User user = new User();
        return user;
    }
}
