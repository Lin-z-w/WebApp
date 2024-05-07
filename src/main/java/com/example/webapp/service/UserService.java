package com.example.webapp.service;

import com.example.webapp.model.User;
import com.example.webapp.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean registerUser(User user) {
        // 检查用户名是否已经存在
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            // 如果存在，返回 false
            return false;
        } else {
            // 如果不存在，生成用户ID
            String userId = generateUserId();
            // 设置用户ID
            user.setId(userId);
            // 保存用户
            userRepository.save(user);
            return true;
        }
    }

    private String generateUserId() {
        // 在这里编写生成用户ID的逻辑，可以使用 UUID 或其他方法来生成唯一的字符串
        return UUID.randomUUID().toString();
    }

    public User findUserByUsername(String username) {
        // 根据用户名查询用户
        return userRepository.findByUsername(username);
    }
}
