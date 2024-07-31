package com.Tancem.PIS.ServiceImpl;

import com.Tancem.PIS.DAO.JwtAuthenticationResponse;
import com.Tancem.PIS.DAO.RefreshTokenRequest;
import com.Tancem.PIS.DAO.SigninRequest;
import com.Tancem.PIS.DAO.SignupRequest;
import com.Tancem.PIS.Model.User;
import com.Tancem.PIS.Repository.UserRepository;
import com.Tancem.PIS.Service.AuthenticationService;
import com.Tancem.PIS.Service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final Set<String> tokenBlacklist = new HashSet<>();

    @Override
    public JwtAuthenticationResponse signin(SigninRequest signinRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signinRequest.getEmpId(), signinRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = (User) userDetails; // Assuming User implements UserDetails

        String jwt = jwtService.generateToken(Map.of(), userDetails);

        JwtAuthenticationResponse.Data responseData = new JwtAuthenticationResponse.Data(
                user.getEmpId(),
                user.getRole().name()
        );

        return new JwtAuthenticationResponse(
                jwt,
                200,
                "Login success!",
                "You are now logged in.",
                responseData
        );
    }

    @Override
    public JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        String jwt = jwtService.generateRefreshToken(refreshTokenRequest.getToken());
        return new JwtAuthenticationResponse(jwt, 200, "Token refreshed", "A new token has been issued.", null);
    }

    @Override
    public User signup(SignupRequest signupRequest) {
        if (userRepository.existsByEmpId(signupRequest.getEmpId())) {
            throw new RuntimeException("Error: Employee ID is already taken!");
        }
        User user = new User();
        user.setEmpId(signupRequest.getEmpId());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        user.setRole(User.Role.valueOf(signupRequest.getRole()));
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy(signupRequest.getEmpId());
        userRepository.save(user);
        return user;
    }

    @Override
    public void invalidateToken(String token) {
        tokenBlacklist.add(token);
    }

    @Override
    public boolean isTokenInvalid(String token) {
        return tokenBlacklist.contains(token);
    }

    @Override
    public Map<String, String> invalidateTokenAndGetUserData(String token) {
        tokenBlacklist.add(token);
        String empId = jwtService.extractUserName(token);
        User user = userRepository.findByEmpId(empId).orElse(null);

        Map<String, String> userData = new HashMap<>();
        if (user != null) {
            userData.put("empId", user.getEmpId());
            userData.put("role", user.getRole().name());
        }

        return userData;
    }
}