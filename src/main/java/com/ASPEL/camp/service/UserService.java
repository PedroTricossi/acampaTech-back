package com.ASPEL.camp.service;

import com.ASPEL.camp.dto.UserDto;
import com.ASPEL.camp.model.User;
import com.ASPEL.camp.payload.request.SignupRequest;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    void saveUser(SignupRequest signUpRequest) throws Exception;
}
