package com.hello.courses.hi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
    
    @RequestMapping("/hi")
    public String sayHi(){
        return "Hi!";
    }
}
