package com.example.webapp.repository;

import com.example.webapp.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserRepository {

    @Select("SELECT * FROM users WHERE username = #{username}")
    User findByUsername(String username);

    @Insert("INSERT INTO users (username, password, email, address, img, phone, balance) VALUES (#{username}, #{password}, #{email}, #{address}, #{img}, #{phone}, #{balance})")
    void save(User user);

    @Insert("UPDATE users SET balance = #{balance} WHERE username = #{username}")
    void updateUserBalance(User user);
}
