package com.Tancem.PIS.DAO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtAuthenticationResponse {
    private String token;
    private int status;
    private String message;
    private String note;
    private Data data;

    @lombok.Data
    @AllArgsConstructor
    public static class Data {
        private String empId;
        private String role;
    }
}
