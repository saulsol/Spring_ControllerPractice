package com.example.webmvcpractice.controller;

import com.example.webmvcpractice.dto.ValidationDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/validation")
public class ValidationController {

    @GetMapping
    public String validationTestGetMapping(@Valid @RequestBody ValidationDTO validationDTO){
        return "내용 잘 받았습니당";
    }






}
