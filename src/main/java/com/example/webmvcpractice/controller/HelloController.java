package com.example.webmvcpractice.controller;


import com.example.webmvcpractice.dto.ResponseDTO;
import com.example.webmvcpractice.dto.TestRequestBodyDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class HelloController {
    //localhost:8080 에게 http GET 메소드를 이용해 test라는 리소스를 요청한다는 뜻
    // 따라서 서버는 자기 주소를 제외한 /{리소스} 부분을 이해하고, 또 어떤 HTTP 메서드를 이용했는지 알아야 한다.
    @GetMapping
    public String testController(){
        return "hello";
    }

     //매개변수를 넘겨받는 방법
    // @PathVariable 을 이용하면 /{id} 처럼 URI 경로로 넘어오는 값을 변수로 받아 올 수 있다.
    // localhost:8080/{id}
    @GetMapping("/testGetMapping")
    public String testGetMapping(){
        return "getMappingTest";
    }


    @GetMapping("/{user}/{id}")
    public String testControllerWithPathVariable(@PathVariable String user,
                                                 @PathVariable(required = false) int id){
        return "user : "+ user +", id : " + id;
    }
//     @GetMapping("/{id}") 는 경로로 들어오는 임의의 숫자 또는 문자를 변수 id에 매핑하라는 뜻.
//     그림에서는 id가 정수형이므로 test/ 다음에 오는 정수가 id에 매핑된다.
//     required = false는 이 매개변수가 꼭 필요한건 아니라는 뜻이다.


    @GetMapping("/testRequestParam")
    public String testControllerRequestParam(@RequestParam(required = false) int id){
        return "Hello " + id;
    }
    //@RequestParam 형식은 key value 형식으로 오는 데이터를 값을 변수로 받아올 수 있다.
    // localhost:8080/test/testRequestParam?id=15


    @GetMapping("/testRequestBody")
    public String testControllerRequestBody(@RequestBody TestRequestBodyDTO dto){
        return "id : " + dto.id + ", " + "message : " + dto.message;
    }
    // @RequestBody TestRequestBodyDTO dto 는 RequestBody 로 날라오는 JSON 을
    // TestRequestBodyDTO 오브젝트로 변환해 가져오라는 뜻이다. -> 제이슨 객체 자바 객체로 변환(스프링에서 해줌)
    // 클라이언트는 요청 바디로 JSON 형태의 문자열을 넘겨준다.
    // 이 JSON의 내부는 의미적으로 TestRequestBodyDTO와 같아야 한다.


    @GetMapping("/testResponseBody")
    public ResponseDTO<String> testControllerResponseBody(){
        List<String> list = new ArrayList<>();
        list.add("hi BABO");
        list.add("YES, YOUR BABO");

        return  ResponseDTO.<String>builder()
                .data(list)
                .build();
    }




}
