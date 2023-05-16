package com.example.webmvcpractice.exception;

import com.example.webmvcpractice.controller.ValidationController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice(basePackageClasses = ValidationController.class)
// 해당 클래스에서 발생하는 오류는 전부 이 핸들러 객체에서 처리
public class GlobalExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Map<String, String>> exceptionHandler(Exception e){
        HttpHeaders responseHeaders = new HttpHeaders();

        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        System.out.println( "Advice 내 메세지 : " + e.getLocalizedMessage());

        Map<String, String> map = new HashMap<>();
        map.put("Error Type", httpStatus.getReasonPhrase());
        map.put("code", "400");
        map.put("message", "에러 발생");

        return new ResponseEntity<>(map, responseHeaders, httpStatus);
    }

}
