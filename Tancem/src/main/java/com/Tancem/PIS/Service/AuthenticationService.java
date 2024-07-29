package com.Tancem.PIS.Service;

import com.Tancem.PIS.DAO.JwtAuthenticationResponse;
import com.Tancem.PIS.DAO.RefreshTokenRequest;
import com.Tancem.PIS.DAO.SigninRequest;
import com.Tancem.PIS.DAO.SignupRequest;
import com.Tancem.PIS.Model.User;

public interface AuthenticationService {
    JwtAuthenticationResponse signin(SigninRequest signinRequest);
    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
    User signup(SignupRequest signupRequest);
}
