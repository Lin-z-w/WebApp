package com.example.webapp.utils;

import java.util.UUID;

public class IDUtils {
    public static String generateUniqueId() {
        // 在这里编写生成用户ID的逻辑，可以使用 UUID 或其他方法来生成唯一的字符串
        return UUID.randomUUID().toString();
    }
}
