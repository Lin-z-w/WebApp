package com.example.webapp.service;

import com.example.webapp.model.User;
import com.example.webapp.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.example.webapp.utils.IDUtils.generateUniqueId;

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
            // 保存用户
            userRepository.save(user);
            return true;
        }
    }

    public User findUserByUsername(String username) {
        // 根据用户名查询用户
        return userRepository.findByUsername(username);
    }

    public void recharge(String username, Double amount) {
        // 充值
        User user = userRepository.findByUsername(username);
        user.setBalance(user.getBalance() + amount);
        userRepository.updateUserBalance(user);
    }

    public User updateUserInfo(String username, String email, String address, String phone, String img) {
        // 更新用户信息
        User user = userRepository.findByUsername(username);
        user.setEmail(email);
        user.setAddress(address);
        user.setPhone(phone);
        user.setImg(img);
        userRepository.updateUserInformation(user);
        return user;
    }
}
