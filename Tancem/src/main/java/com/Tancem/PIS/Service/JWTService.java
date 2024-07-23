package com.Tancem.PIS.Service;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JWTService {
    String extractUserName(String token);  // Ensure method name is correct
    String generateToken(UserDetails userDetails);
    boolean validateToken(String token, UserDetails userDetails);

    public String generateRefreshToken(Map<String ,Object> extractClaims , UserDetails userDetails);
}
