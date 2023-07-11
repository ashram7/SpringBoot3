package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
//@RequestMapping(value = { "hello", "hellospring" })
public class HelloViewController {
    @GetMapping("view")
    //@GetMapping( value = { "view", "viewspring" })
    public String helloView(){
        return "hello";
    }
}
