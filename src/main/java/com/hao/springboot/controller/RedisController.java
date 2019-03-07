package com.hao.springboot.controller;


import com.hao.springboot.domin.JsonData;
import com.hao.springboot.domin.User;
import com.hao.springboot.utils.JsonUtils;
import com.hao.springboot.utils.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/sboot/redis")
public class RedisController {


    @Autowired
    private RedisClient redis;

    @GetMapping(value = "add")
    public Object add(){

        //redisTpl.opsForValue().set("wang","zhihao");

        redis.set("username","hao");
        return JsonData.buildSuccess("ok");
    }

    @GetMapping(value = "get")
    public Object Get(){

        //String value = redisTpl.opsForValue().get("wang");

        String value = redis.get("username");

        return JsonData.buildSuccess(value);
    }

    @GetMapping(value = "saveuser")
    public Object saveUser(){
        User user = new User(11, "123456", "12312341234", new Date());
        boolean flag = redis.set("base:user:11", JsonUtils.obj2String(user));

        return JsonData.buildSuccess(flag);
    }

    @GetMapping(value = "getuser")
    public Object getUser(){
        String value = redis.get("base:user:11");
        User user = JsonUtils.string2Obj(value, User.class);

        return JsonData.buildSuccess(user);
    }



}
