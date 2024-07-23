package com.Tancem.PIS.DAO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtAuthenticationResponse {
    private String token;
    private String refreshToken;
}
