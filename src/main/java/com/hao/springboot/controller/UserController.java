package com.hao.springboot.controller;


import com.hao.springboot.domin.JsonData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sboot")
public class UserController {


    @GetMapping(value="user")
    public Object account(){

        return JsonData.buildSuccess("hao");

    }



}
