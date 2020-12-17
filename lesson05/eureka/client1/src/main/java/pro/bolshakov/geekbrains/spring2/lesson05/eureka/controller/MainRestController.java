package pro.bolshakov.geekbrains.spring2.lesson05.eureka.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello I am Client #1";
    }

}
