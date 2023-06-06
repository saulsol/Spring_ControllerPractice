package com.example.webmvcpractice.S3Config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Configuration
@RequiredArgsConstructor
public class AwsS3Service {

    private final AmazonS3 s3Client;


    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;
    @Value("${cloud.aws.credentials.secret-key}")
    private String secretKey;
    @Value("${cloud.aws.s3.bucket}")
    private String bucket;
    @Value("${cloud.aws.region.static}")
    private String region;

    @PostConstruct
    public AmazonS3 amazonS3() {

        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
        return AmazonS3ClientBuilder.standard()
                .withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }


    public List<String> upload(List<MultipartFile> multipartFile){

        List<String> imgUrlList = new ArrayList<>();

        for(MultipartFile file : multipartFile){

            String fileName = createFileName(file.getOriginalFilename());
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(file.getSize());
            objectMetadata.setContentType(file.getContentType());

            try(InputStream inputStream = file.getInputStream()) {
                s3Client.putObject(new PutObjectRequest(bucket, fileName, inputStream, objectMetadata));



            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        return null;
    }


    //이미지 파일명 중복 방지
    private String createFileName(String fileName){
      return UUID.randomUUID().toString().concat(getFileExtension(fileName));
    }




    // 이미지 파일 형식이 올바른지 아닌지 검사
    private String getFileExtension(String fileName){

        if(fileName.length() == 0){
            System.out.println("이미지 업로드 실패");
        }

        ArrayList<String> fileValidate = new ArrayList<>();
        fileValidate.add(".jpg");
        fileValidate.add(".jpeg");
        fileValidate.add(".png");
        fileValidate.add(".JPEG");
        fileValidate.add(".PNG");

        String idxFileName = fileName.substring(fileName.lastIndexOf("."));
        // .부터 시작하는 문자열을 리턴

        if(!fileValidate.contains(idxFileName)){
            System.out.println("이미지 파일 형식이 잘못되었음");
        }

        return fileName.substring(fileName.lastIndexOf(".")); // 확장자 리턴
    }





}
