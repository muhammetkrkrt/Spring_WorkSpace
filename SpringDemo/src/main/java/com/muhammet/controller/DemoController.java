package com.muhammet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("request")
    public String request(){
        return "muhammet";
    }

    @GetMapping("/getlist")
    public List<String> listName(){
        List<String> names = new ArrayList<>();
        names.add("Ali");
        names.add("Kaan");
        names.add("Asli");
        return names;
    }
}
