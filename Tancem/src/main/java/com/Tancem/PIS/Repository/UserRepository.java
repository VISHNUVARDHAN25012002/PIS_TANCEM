package com.Tancem.PIS.Repository;

import com.Tancem.PIS.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmpId(String empId);
    Optional<User> findByEmpId(String empId);
}