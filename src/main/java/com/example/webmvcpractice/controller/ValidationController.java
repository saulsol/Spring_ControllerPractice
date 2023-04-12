package com.example.webmvcpractice.controller;

import com.example.webmvcpractice.dto.ValidationDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/validation")
public class ValidationController {

    @GetMapping
    public String validationTestGetMapping(@Validated @RequestBody ValidationDTO validationDTO){
        return "내용 잘 받았습니당";
    }
    // Spring validation 을 통과하지 못하는 경우, Bad Request 가 나가게 된다.





}
