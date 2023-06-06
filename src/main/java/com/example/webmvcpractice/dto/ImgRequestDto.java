package com.example.webmvcpractice.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
public class ImgRequestDto {
    private MultipartFile file;
}
