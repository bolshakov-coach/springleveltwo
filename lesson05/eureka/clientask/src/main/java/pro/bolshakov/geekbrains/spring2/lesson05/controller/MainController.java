package pro.bolshakov.geekbrains.spring2.lesson05.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController {

    private final RestTemplate restTemplate;

    public MainController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("")
    public String sendRequestToClient(){
        String clientAnswer = restTemplate.getForObject("http://eureka-client/hello", String.class);

        return "Answer -> " + clientAnswer;
    }
}
