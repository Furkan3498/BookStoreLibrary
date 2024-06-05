package com.example.BookStoreLibrary.configure;


import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsConfigure {
    public static final String REGION = "eu-west-3";
    public static final String ACCESS_KEY = "AGHLŞKJGHLŞKJŞ";
    public static final String SECRET_KEY = "JKHdhasjkdhaskhHAŞALSDKK2421245";

    @Bean
    public AmazonS3 s3Client(){
        return AmazonS3ClientBuilder.standard()
                .withRegion(REGION)
                .withCredentials(new StaticCredentialsProvider(new BasicAWSCredentials(ACCESS_KEY,SECRET_KEY)))
                .build();
    }
}
