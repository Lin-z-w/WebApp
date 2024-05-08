package com.example.webapp.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class JwtUtils {

    // 从配置文件中读取密钥
    private static final String SECRET_KEY;

    static {
        Properties props = new Properties();
        try (InputStream inputStream = JwtUtils.class.getClassLoader().getResourceAsStream("application.properties")) {
            props.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SECRET_KEY = props.getProperty("jwt.secretKey");
    }

    // 生成 JWT 令牌
    public static String generateToken(String username, String userId) {
        // 设置过期时间，这里设置为 1 小时后过期
        Date expirationDate = new Date(System.currentTimeMillis() + 3600 * 1000);

        // 构建 JWT 头部
        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("typ", "JWT");

        // 使用 JJWT 库生成 JWT
        String token = Jwts.builder()
                .claim("username", username) // 将用户名放入 JWT
                .claim("userId", userId) // 将用户ID放入 JWT
                .setExpiration(expirationDate) // 设置 JWT 过期时间
                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()), SignatureAlgorithm.HS256) // 使用指定的密钥和签名算法签名 JWT
                .setHeader(headerMap) // 设置 JWT 头部
                .compact(); // 生成 JWT 字符串

        return token;
    }




    // 解析 JWT 令牌
    public static Jws<Claims> parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
                .build()
                .parseClaimsJws(token);
    }
}
