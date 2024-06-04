package com.example.webapp.rest;

import com.example.webapp.rest.api.UploadImageApi;
import com.example.webapp.rest.dto.UploadImage200ResponseDto;
import io.minio.*;
import io.minio.errors.MinioException;
import io.minio.http.Method;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@RestController
public class UploadImgController implements UploadImageApi {

    @Value("${minio.endpoint}")
    private String endpoint;

    @Value("${minio.accessKey}")
    private String accessKey;

    @Value("${minio.secretKey}")
    private String secretKey;

    @Value("${minio.bucketName}")
    private String bucketName;

    @Value("${minio.externalEndpoint}")
    private String externalEndpoint;

    @Override
    public ResponseEntity<UploadImage200ResponseDto> uploadImage(MultipartFile file) {
        try {
            // 初始化 MinIO 客户端
            MinioClient minioClient = MinioClient.builder()
                    .endpoint(endpoint)
                    .credentials(accessKey, secretKey)
                    .build();

            // 检查桶是否存在，如果不存在则创建它
            boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
            if (!found) {
                System.out.println("Creating bucket " + bucketName);
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());

                // 设置存储桶策略
                String policy = "{\n" +
                        "    \"Version\":\"2012-10-17\",\n" +
                        "    \"Statement\":[\n" +
                        "        {\n" +
                        "            \"Sid\":\"PublicRead\",\n" +
                        "            \"Effect\":\"Allow\",\n" +
                        "            \"Principal\":\"*\",\n" +
                        "            \"Action\":[\"s3:GetObject\"],\n" +
                        "            \"Resource\":[\"arn:aws:s3:::" + bucketName + "/*\"]\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}";
                minioClient.setBucketPolicy(SetBucketPolicyArgs.builder().bucket(bucketName).config(policy).build());
            }


            // 上传文件到桶
            String objectName = file.getOriginalFilename();
            try (InputStream inputStream = file.getInputStream()) {
                minioClient.putObject(
                        PutObjectArgs.builder()
                                .bucket(bucketName)
                                .object(objectName)
                                .stream(inputStream, file.getSize(), -1)
                                .contentType(file.getContentType())
                                .build()
                );
            }

            // 构建文件的 URL
            String fileUrl = minioClient.getPresignedObjectUrl(
                    GetPresignedObjectUrlArgs.builder()
                            .method(Method.GET)
                            .bucket(bucketName)
                            .object(objectName)
                            .expiry(7, TimeUnit.DAYS)
                            .build()
            );

            // 替换预签名 URL 的主机部分
            URL url = new URL(fileUrl);
            String externalUrl = new URL(url.getProtocol(), externalEndpoint, url.getPort(), url.getFile()).toString();

            // 创建响应对象
            UploadImage200ResponseDto responseDto = new UploadImage200ResponseDto();
            responseDto.setCode(1);
            responseDto.setData(externalUrl);

            System.out.println("Upload successful: " + externalUrl);

            // 返回成功响应
            return ResponseEntity.ok(responseDto);

        } catch (MinioException | IOException | NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();

            // 创建失败响应对象
            UploadImage200ResponseDto responseDto = new UploadImage200ResponseDto();
            responseDto.setCode(0);
            responseDto.setData("Upload failed");

            // 返回失败响应
            return ResponseEntity.status(500).body(responseDto);
        }
    }
}
