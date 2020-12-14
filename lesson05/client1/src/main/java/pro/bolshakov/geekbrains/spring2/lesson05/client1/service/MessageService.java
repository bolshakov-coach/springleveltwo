package pro.bolshakov.geekbrains.spring2.lesson05.client1.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Value("${message.example1}")
    private String messageExample1;
    @Value("${message.example2}")
    private String messageExample2;

    public String getMessageExample1() {
        return messageExample1;
    }

    public String getMessageExample2() {
        return messageExample2;
    }
}
