package pro.bolshakov.geekbrains.spring2.lesson05.client1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.bolshakov.geekbrains.spring2.lesson05.client1.service.MessageService;

@RestController
public class MainController {

    private final MessageService messageService;

    public MainController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/message1")
    public String getMessage1(){
        return messageService.getMessageExample1();
    }

    @GetMapping("/message2")
    public String getMessage2(){
        return messageService.getMessageExample2();
    }

}
