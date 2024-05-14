package com.example.webapp.rest;

import com.example.webapp.rest.api.UploadImageApi;
import com.example.webapp.rest.dto.UploadImage200ResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@RestController
public class UploadImgController implements UploadImageApi {

    // 文件上传目录路径
    private static final String UPLOAD_DIR = "src/main/resources/static/";

    @Value("${server.port}")
    private String port;

    @Override
    public ResponseEntity<UploadImage200ResponseDto> uploadImage(MultipartFile file) {
        System.out.println("uploadImage");
        try {
            // 获取文件名
            String originalFileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

            // 生成唯一文件名
            String uniqueFileName = generateUniqueFileName(originalFileName);

            // 检查上传目录是否存在，不存在则创建
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // 保存文件到上传目录
            Path filePath = uploadPath.resolve(uniqueFileName);
            Files.copy(file.getInputStream(), filePath);


            // 构造返回的图片 URL
            String url = "http://localhost:"+ port + "/" + uniqueFileName;

            System.out.println(url);

            return ResponseEntity.ok(new UploadImage200ResponseDto().code(1).data(url));
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload image", e);
        }
    }

    // 生成唯一文件名
    private String generateUniqueFileName(String originalFileName) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String timestamp = now.format(formatter);
        String extension = StringUtils.getFilenameExtension(originalFileName);
        return timestamp + "_" + originalFileName;
    }
}

//
//package com.example.webapp.rest;
//
//        import com.example.webapp.rest.api.UploadImageApi;
//        import com.example.webapp.rest.dto.UploadImage200ResponseDto;
//        import org.springframework.http.ResponseEntity;
//        import org.springframework.web.bind.annotation.RestController;
//        import org.springframework.web.multipart.MultipartFile;
//        import org.springframework.util.StringUtils;
//
//        import java.io.IOException;
//        import java.io.InputStream;
//        import java.time.LocalDateTime;
//        import java.time.format.DateTimeFormatter;
//        import java.util.Objects;
//
//        import org.springframework.beans.factory.annotation.Value;
//        import org.springframework.web.client.RestTemplate;
//
//@RestController
//public class UploadImgController implements UploadImageApi {
//
//    @Value("${minio.url}")
//    private String minioUrl;
//
//    @Value("${minio.accessKey}")
//    private String minioAccessKey;
//
//    @Value("${minio.secretKey}")
//    private String minioSecretKey;
//
//    @Override
//    public ResponseEntity<UploadImage200ResponseDto> uploadImage(MultipartFile file) {
//        System.out.println("uploadImage");
//        try {
//            // 获取文件名
//            String originalFileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
//
//            // 生成唯一文件名
//            String uniqueFileName = generateUniqueFileName(originalFileName);
//
//            // 上传文件到 MinIO
//            uploadFileToMinio(file.getInputStream(), uniqueFileName);
//
//            // 构造返回的图片 URL
//            String url = "http://localhost:9000/" + uniqueFileName;
//
//            System.out.println(url);
//
//            return ResponseEntity.ok(new UploadImage200ResponseDto().code(1).data(url));
//        } catch (IOException e) {
//            throw new RuntimeException("Failed to upload image", e);
//        }
//    }
//
//    // 生成唯一文件名
//    private String generateUniqueFileName(String originalFileName) {
//        LocalDateTime now = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
//        String timestamp = now.format(formatter);
//        String extension = StringUtils.getFilenameExtension(originalFileName);
//        return timestamp + "_" + originalFileName;
//    }
//
//    // 上传文件到 MinIO
//    private void uploadFileToMinio(InputStream inputStream, String fileName) {
//        RestTemplate restTemplate = new RestTemplate();
//        String uploadUrl = minioUrl + "/upload/" + fileName;
//        try {
//            restTemplate.put(uploadUrl, inputStream);
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to upload file to MinIO", e);
//        }
//    }
//}
