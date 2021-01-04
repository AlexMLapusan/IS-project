package com.spring.mappers;

import com.spring.dto.RegisterAdminDTO;
import com.spring.dto.RegisterUserDTO;
import com.spring.entity.Admin;
import com.spring.entity.User;

import java.util.UUID;

public class AdminMapper {



    public static Admin registerUserDTOToEntity(RegisterAdminDTO registerAdminDTO) {
        Admin newAdmin = new Admin();
        newAdmin.setEmail(registerAdminDTO.getEmail());
        newAdmin.setPassword(registerAdminDTO.getPassword());
        newAdmin.setConfirmed(false);
        return newAdmin;
    }
}
