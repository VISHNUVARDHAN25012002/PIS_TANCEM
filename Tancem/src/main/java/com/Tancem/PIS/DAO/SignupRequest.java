package com.Tancem.PIS.DAO;

import lombok.Data;

@Data
public class SignupRequest {
    private String empId;
    private String password;
    private String role;
}
