package com.Tancem.PIS.Service;

import com.Tancem.PIS.DAO.JwtAuthenticationResponse;
import com.Tancem.PIS.DAO.RefreshTokenRequest;
import com.Tancem.PIS.DAO.SigninRequest;
import com.Tancem.PIS.DAO.SignupRequest;
import com.Tancem.PIS.Model.User;

import java.util.Map;

public interface AuthenticationService {
    JwtAuthenticationResponse signin(SigninRequest signinRequest);
    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
    User signup(SignupRequest signupRequest);
    void invalidateToken(String token);
    boolean isTokenInvalid(String token);
    Map<String, String> invalidateTokenAndGetUserData(String token); // Add this method
}
