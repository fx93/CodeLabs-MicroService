package com.fx.microone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String greeting(){
        return "Hello World";
    }

}
