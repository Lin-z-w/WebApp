package com.example.webapp.service;

import com.example.webapp.model.User; // 假设 User 是用户模型类
import com.example.webapp.repository.UserRepository; // 假设 UserRepository 是用户数据库操作接口

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserByUsername(String username) {
        // 根据用户名查询用户
        return userRepository.findByUsername(username);
    }
}
