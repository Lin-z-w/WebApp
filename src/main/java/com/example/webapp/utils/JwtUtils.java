package com.example.webapp.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtils {

    // 密钥，用于签名和解析 JWT
    public static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // 生成 JWT 令牌
    public static String generateToken(String username, String userId) {
        // 设置过期时间，这里设置为 1 小时后过期
        Date expirationDate = new Date(System.currentTimeMillis() + 3600 * 1000);

        // 使用 JJWT 库生成 JWT
        String token = Jwts.builder()
                .claim("username", username) // 将用户名放入 JWT
                .claim("userId", userId) // 将用户ID放入 JWT
                .setExpiration(expirationDate) // 设置 JWT 过期时间
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256) // 使用指定的密钥和签名算法签名 JWT
                .compact(); // 生成 JWT 字符串

        return token;
    }

    // 解析 JWT 令牌
    public static Jws<Claims> parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token);
    }
}
