package com.Tancem.PIS.ServiceImp;

import com.Tancem.PIS.Model.User;
import com.Tancem.PIS.Repository.UserRepository;
import com.Tancem.PIS.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String empId) throws UsernameNotFoundException {
        User user = userRepository.findByEmpId(empId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with empId: " + empId));

        // Assuming User implements UserDetails
        return user;
    }
}
