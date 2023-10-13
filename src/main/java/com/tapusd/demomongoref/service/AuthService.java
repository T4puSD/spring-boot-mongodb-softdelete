package com.tapusd.demomongoref.service;

import com.tapusd.demomongoref.domain.User;
import com.tapusd.demomongoref.dto.request.AuthRequest;
import com.tapusd.demomongoref.dto.request.RegistrationRequest;
import com.tapusd.demomongoref.dto.response.AuthResponse;

public interface AuthService {

    User registerUser(RegistrationRequest request);

    AuthResponse authenticate(AuthRequest authRequest);

    String createJWT(User user);

    User verifyJWT(String jwt);
}
