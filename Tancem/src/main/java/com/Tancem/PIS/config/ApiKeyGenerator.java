package com.Tancem.PIS.config;

import java.util.UUID;

public class ApiKeyGenerator {
    public static void main(String[] args) {
        String apiKey = UUID.randomUUID().toString().replace("-", "");
        System.out.println("Generated API Key: " + apiKey);
    }
}
