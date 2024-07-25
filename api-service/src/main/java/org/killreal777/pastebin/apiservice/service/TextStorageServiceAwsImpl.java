package org.killreal777.pastebin.apiservice.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class TextStorageServiceAwsImpl implements TextStorageService {

    @Value("${application.bucket.name}")
    private String bucketName;

    private final S3Client s3Client;

    @Override
    public void upload(String filename, String text) {
        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(filename)
                .build();
        s3Client.putObject(request, RequestBody.fromString(text));
    }

    @Override
    @SneakyThrows
    public String download(String filename) {
        ResponseInputStream<GetObjectResponse> response = s3Client.getObject(
                request -> request.bucket(bucketName).key(filename));
        return StreamUtils.copyToString(response, StandardCharsets.UTF_8);
    }

    @Override
    public void delete(String filename) {
        DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
                .bucket(bucketName)
                .key(filename)
                .build();
        s3Client.deleteObject(deleteObjectRequest);
    }

}
