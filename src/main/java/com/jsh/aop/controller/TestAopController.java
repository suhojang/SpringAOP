package com.jsh.aop.controller;

import com.jsh.aop.service.TestAopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestAopController {
    @Autowired
    private TestAopService service;

    @GetMapping(value="/noAop")
    public String noAop(){
        return service.test();
    }

    @GetMapping(value="/aop")
    public String aop(){
        return service.testAop();
    }
}
