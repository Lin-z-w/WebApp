package com.example.webapp;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import org.junit.jupiter.api.Test;

import static com.example.webapp.utils.JwtUtils.generateToken;
import static com.example.webapp.utils.JwtUtils.parseToken;


public class Tests {

    @Test
    public void testGenerateToken() {
        String jwtToken = generateToken("Tom", "123456");
        System.out.println("Generated JWT Token: " + jwtToken);
    }

    @Test
    public void testParseToken() {
        String jwtToken = generateToken("Tom", "123456");
        System.out.println("Generated JWT Token: " + jwtToken);
        Jws<Claims> claimsJws = parseToken(jwtToken);

        // Extract claims
        try {
            Claims body = claimsJws.getBody();
            String username = body.get("username", String.class);
            String userId = body.get("userId", String.class);

            // Print username and userId
            System.out.println("Username: " + username);
            System.out.println("UserID: " + userId);
        } catch (JwtException e) {
            System.out.println("Invalid JWT token");
        }
    }
}
