package com.example.webmvcpractice.controller;

import com.example.webmvcpractice.S3Config.FileUploadService;
import com.example.webmvcpractice.dto.ImgDto;
import com.example.webmvcpractice.dto.ImgRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class S3Controller {

    private final FileUploadService fileUploadService;

    @PostMapping("/upload")
    public ImgDto imgUpload(@RequestParam MultipartFile image) throws IOException {

        return fileUploadService.uploadImage(image, "post");

    }





}
