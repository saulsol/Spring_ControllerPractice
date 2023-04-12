package com.example.webmvcpractice.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ValidationDTO {

    @NotBlank
    String name;

    @Range(min = 10, message = "10살 이상부터 사용 가능합니다.")
    int age;

    @NotNull(message = "집 주소는 필수입니다. ")
    String address;


}
