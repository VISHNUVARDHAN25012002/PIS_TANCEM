package com.Tancem.PIS.ServiceImp;

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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public JwtAuthenticationResponse signin(SigninRequest signinRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signinRequest.getEmpId(), signinRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Map<String, Object> claims = new HashMap<>();
        String jwt = jwtService.generateToken(claims, userDetails);
        return new JwtAuthenticationResponse(jwt);
    }

    @Override
    public JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        String jwt = jwtService.generateRefreshToken(refreshTokenRequest.getToken());
        return new JwtAuthenticationResponse(jwt);
    }

    @Override
    public void signup(SignupRequest signupRequest) {
        if (userRepository.existsByEmpId(signupRequest.getEmpId())) {
            throw new RuntimeException("Error: Employee ID is already taken!");
        }
        User user = new User();
        user.setEmpId(signupRequest.getEmpId());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        user.setRole(User.Role.valueOf(signupRequest.getRole()));
        userRepository.save(user);
    }
}
