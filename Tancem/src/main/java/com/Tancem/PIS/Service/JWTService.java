package com.Tancem.PIS.Service;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JWTService {
    String extractUserName(String token);
    String generateToken(Map<String, Object> claims, UserDetails userDetails);
    String generateRefreshToken(String token);
    boolean validateToken(String token, UserDetails userDetails);
    boolean validateToken(String token);
    void invalidateToken(String token);  // New method for invalidation
}
