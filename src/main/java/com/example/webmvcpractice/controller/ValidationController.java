package com.example.webmvcpractice.controller;

import com.example.webmvcpractice.dto.ValidationDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/validation")
public class ValidationController {

    @PostMapping
    public String validationTestGetMapping(@Validated @RequestBody ValidationDTO validationDTO){
        System.out.println(validationDTO.toString());
        return "내용 잘 받았습니당";
    }
    // Spring validation 을 통과하지 못하는 경우, Bad Request 가 나가게 된다.





}
