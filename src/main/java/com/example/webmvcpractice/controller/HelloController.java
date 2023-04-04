package com.example.webmvcpractice.controller;

import com.example.webmvcpractice.dto.ExamDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class HelloController {
    //localhost:8080 에게 http GET 메소드를 이용해 test라는 리소스를 요청한다는 뜻
    // 따라서 서버는 자기 주소를 제외한 /{리소스} 부분을 이해하고, 또 어떤 HTTP 메서드를 이용했는지 알아야 한다.
    @GetMapping
    public String testController(){
        return "hello";
    }






}
