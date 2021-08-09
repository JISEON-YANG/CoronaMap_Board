package com.example.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
public class HelloController {
    private final HttpSession httpSession;
//    @GetMapping("/")
//    public String hello(){
//        return "hello";
//    }

    @GetMapping("/session")
    public String getSession(){
        System.out.println(httpSession.getId());
        return httpSession.getId();
    }
}
