package cn.itcast.controller;

import cn.itcast.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${personName}")
    private String personName;
    @Autowired
    private Person person;

    @GetMapping("hello")
    public String hello() {
        return "hello spring-boot-022***" + person;
    }
}
